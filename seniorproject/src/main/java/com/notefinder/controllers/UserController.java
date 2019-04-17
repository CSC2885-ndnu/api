package com.notefinder.controllers;  
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notefinder.service.UserManager;
import com.notefinder.models.User;
import com.notefinder.models.UserPass;

@Controller
public class UserController {
	
    @Autowired    
    UserManager manager;

    @RequestMapping(value = "/userLogin/{userName}/{password}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> tryLogin(@PathVariable String userName, @PathVariable String password) {
        User user = manager.getUserByNameAndPassword(userName, password);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/userById/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = manager.getUserById(id);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getPassword/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserPass>> getPassword(@PathVariable int id) {
        List<UserPass> user = manager.getPassword(id);
        if(user == null){
            return new ResponseEntity<List<UserPass>>(HttpStatus.NOT_FOUND);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<UserPass>>(user, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/usersjson/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = manager.getUser();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    // View users in a list
    @RequestMapping("/viewUser")    
    public String viewuser(Model m){    
        List<User> list=manager.getUser();    
        m.addAttribute("list",list);  
        return "users";    
    } 
	
    // Adding Users
    @RequestMapping(value = "/addUser" , method = RequestMethod.GET)
    public String viewAddUser(@ModelAttribute("userForm") User user, Map<String, Object> model) {
    	User userForm = new User();    
        model.put("userForm", userForm);
        return "addUser";
    }
    
    @RequestMapping(value = "/addUser" , method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") User user, Map<String, Object> model) {
    	manager.save(user);
        return "home";
    }
    
    // Update users (Need Work)
    @RequestMapping(value = "/updateUser/{id}")
    public String editUser(@PathVariable int id, Model m) {
    	User user = manager.getUserById(id);  
        m.addAttribute(user);
        return "updateUser";
    }
    
    @RequestMapping(value = "/updateUser" , method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user) {
    	manager.update(user);
         
        return "viewUser";
    }
    
    // Delete Users
    @RequestMapping(value = "/deleteUser" , method = RequestMethod.GET)
    public String viewdeleteUser(@ModelAttribute("userDeleteForm") User user, Map<String, Object> model) {
        User userForm = new User();    
        model.put("userForm", userForm);
                 
        return "deleteUser";
    }
    
    @RequestMapping(value = "/deleteUser" , method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("userDeleteForm") User user, Map<String, Object> model) {
         
    	manager.delete(user.getStudentID());
         
        return "home";
    }
    
    // Get users by studentID
    @RequestMapping(value = "/getUser" , method = RequestMethod.GET)
    public String viewGetUser(@ModelAttribute("userGetForm") User user, Map<String, Object> model) {
        System.out.println(user);
         
        return "getUser";
    }
    
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)    
    public String viewGetUser(@ModelAttribute("user_id") User user, Model m) {    
    	User list= manager.getUserById(user.getUser_id());   
        System.out.println(user.getUser_id());
        System.out.println(list);
        
       m.addAttribute("list",list);  
       
        return "viewUser";    
    }

}
