package com.notefinder.controllers;  
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notefinder.service.UserManager;
import com.notefinder.models.User;
import com.notefinder.models.StudentID;

@Controller
public class UserController {
	
    @Autowired    
    UserManager manager;
    
    // View users in s list
    @RequestMapping("/viewuser")    
    public String viewuser(Model m){    
        List<User> list=manager.getUser();    
        m.addAttribute("list",list);  
        return "viewuser";    
    } 
	
    // Addding Users
    @RequestMapping(value = "/adduser" , method = RequestMethod.GET)
    public String viewAddUser(@ModelAttribute("userForm") User user, Map<String, Object> model) {
    	User userForm = new User();    
        model.put("userForm", userForm);

        return "adduser";
    }
    
    @RequestMapping(value = "/adduser" , method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") User user, Map<String, Object> model) {
         
    	manager.save(user);
    	
        return "home";
    }
    
    // Update users
    @RequestMapping(value = "/updateUser" , method = RequestMethod.GET)
    public String viewupdateUser(@ModelAttribute("userUpdateForm") User user, Map<String, Object> model) {
    	User userForm = new User();    
        model.put("userForm", userForm);
                 
        return "updateUser";
    }
    
    @RequestMapping(value = "/updateUser" , method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("userUpdateForm") User user,
            Map<String, Object> model) {
         
    	manager.update(user);
         
        return "home";
    }
    
    // Delete Users
    @RequestMapping(value = "/deleteUser" , method = RequestMethod.GET)
    public String viewdeleteUser(@ModelAttribute("userDeleteForm") User user, Map<String, Object> model) {
        User userForm = new User();    
        model.put("userForm", userForm);
                 
        return "deleteUser";
    }
    
    @RequestMapping(value = "/deleteUser" , method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("userDeleteForm") User user,
            Map<String, Object> model) {
         
    	manager.delete(user.getStudentID());
         
        return "home";
    }
    
    // Get users by studentID
    @RequestMapping(value = "/getUser" , method = RequestMethod.GET)
    public String viewGetUser(@ModelAttribute("userGetForm") StudentID studentID, Map<String, Object> model) {
        System.out.println(studentID);
         
        return "getUser";
    }
    
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)    
    public String viewGetUser(@ModelAttribute("studentID") StudentID studentID, Model m) {    
        User list= manager.getUserById(studentID.getStudentID());   
        System.out.println(studentID.getStudentID());
        System.out.println(list);
        
       m.addAttribute("list",list);  
       
        return "home";    
    }

}
