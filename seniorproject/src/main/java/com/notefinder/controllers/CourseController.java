package com.notefinder.controllers;  
import java.util.List;  
  
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.PathVariable;    
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.notefinder.dao.CourseDao;
import com.notefinder.models.Course; 
import com.notefinder.service.CourseManager;

import java.util.Map;
@Controller    
public class CourseController {    
    @Autowired    
    CourseManager manager;
    
    @RequestMapping("/courses")    
    public String viewpost(Model m){    
        List<Course> list=manager.getCourse();    
        m.addAttribute("list",list);  
        return "courses";    
    }
    
    @RequestMapping("/home")    
    public String home(Model m){    
        return "home";    
    }
//    @RequestMapping("/addCourse")    
//    public String addCourse(Model m){    
//        List<Course> list=manager.getCourse();    
//        m.addAttribute("list",list);  
//        return "addCourse";    
//    } 
    
    @RequestMapping(value = "/addCourse" , method = RequestMethod.GET)
    public String viewAddCourse(@ModelAttribute("courseForm") Course course, Map<String, Object> model) {
        Course courseForm = new Course();    
        model.put("courseForm", courseForm);
        
        //int save = manager.save(courseForm);
         
//        List<String> professionList = new ArrayList<>();
//        professionList.add("Developer");
//        professionList.add("Designer");
//        professionList.add("IT Manager");
//        model.put("professionList", professionList);
         
        return "addCourse";
    }
    
    @RequestMapping(value = "/addCourse" , method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("courseForm") Course course,
            Map<String, Object> model) {
         
    	int save = manager.save(course);
        // implement your own registration logic here...
         
        // for testing purpose:
//        System.out.println("username: " + user.getUsername());
//        System.out.println("password: " + user.getPassword());
//        System.out.println("email: " + user.getEmail());
//        System.out.println("birth date: " + user.getBirthDate());
//        System.out.println("profession: " + user.getProfession());
         
        return "home";
    }
}

