package com.notefinder.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/viewcomment";
    }
    
    @RequestMapping(value = "/updateComment/{id}" , method = RequestMethod.GET)
    public String viewupdateCourse(@PathVariable("id") int id, Map<String, Object> model) {
    	Comment commentForm = manager.getCommentById(id);
        model.put("commentUpdateForm", commentForm);
        return "updateComment";
    }
    
    @RequestMapping(value = "/updateComment" , method = RequestMethod.POST)
    public String updateComment(@ModelAttribute("commentUpdateForm") Comment comment, Map<String, Object> model) {
    	manager.update(comment);
        return "redirect:/viewcomment";
    }
    
    @RequestMapping(value = "/deleteComment/{id}" , method = RequestMethod.GET)
    public String deleteComment(@PathVariable("id") int id, Map<String, Object> model) {
    	manager.delete(id);
        return "redirect:/viewcomment";
    }
}
