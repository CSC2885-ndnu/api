package com.notefinder.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value = "/addComment" , method = RequestMethod.GET)
    public String viewAddComment(@ModelAttribute("commentForm") Comment comment, Map<String, Object> model){
    	Comment commentForm = new Comment();    
        model.put("commentForm", commentForm);
        return "addComment";
    }
    
    @RequestMapping(value = "/addComment" , method = RequestMethod.POST)
    public String addComment(@ModelAttribute("commentForm") Comment comment, Map<String, Object> model){
    	manager.save(comment);
        return "home";
    }
}
