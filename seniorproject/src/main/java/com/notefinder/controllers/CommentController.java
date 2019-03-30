package com.notefinder.controllers;

import java.util.List;    
import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;    

import com.notefinder.models.Comment; 
import com.notefinder.service.CommentManager;
@Controller    
public class CommentController {
    @Autowired    
    CommentManager manager;
    
    @RequestMapping("/viewcomment")    
    public String viewcomment(Model m){    
        List<Comment> list=manager.getComments();    
        m.addAttribute("list",list);  
        return "viewcomment";    
    } 
}
