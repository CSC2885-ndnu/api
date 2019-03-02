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
}

