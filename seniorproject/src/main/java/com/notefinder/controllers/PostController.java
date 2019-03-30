package com.notefinder.controllers;  
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;       
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;
import com.notefinder.models.Post;
import com.notefinder.models.PostID;
import com.notefinder.service.PostManager;
@Controller    
public class PostController {    
    @Autowired    
    PostManager manager;
    
    @RequestMapping("/viewpost")
    public String viewpost(Model m) {
    	List<Post> list=manager.getPosts();
    	m.addAttribute("list", list);
    	return "viewpost";
    }
    
    @RequestMapping("/home")
    public String home(Model m) {
    	return "home";
    }
    
    @RequestMapping(value = "/addPost", method = RequestMethod.GET)
    public String viewAddPost(@ModelAttribute("postForm") Post post, Map<String, Object> model) {
    	Post postForm = new Post();
    	model.put("postForm", postForm);
    	System.out.println("IN GET viewAddPost");
    	return "addPost";
    }
    
    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("postForm") Post post, Map<String, Object> model) {
    	System.out.println("IN POST addPost");
    	manager.save(post);
    	System.out.println("IN POST addPost");
    	return "home";
    }
    
    @RequestMapping(value = "/updatePost", method = RequestMethod.GET)
    public String viewupdatePost(@ModelAttribute("postUpdateForm") Post post, Map<String, Object> model) {
    	Post postForm = new Post();
    	model.put("postForm", postForm);
    	return "updatePost";
    }
    
    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public String updatePost(@ModelAttribute("postUpdateForm") Post post, Map<String, Object> model) {
    	manager.update(post);
    	return "home";
    }
    
    @RequestMapping(value = "/deletePost" , method = RequestMethod.GET)
    public String viewdeletePost(@ModelAttribute("postDeleteForm") Post post, Map<String, Object> model) {
        Post postForm = new Post();    
        model.put("postForm", postForm);
         
        return "deletePost";
    }
    
    @RequestMapping(value = "/deletePost" , method = RequestMethod.POST)
    public String deletePost(@ModelAttribute("postDeleteForm") Post post,
            Map<String, Object> model) {
         
    	manager.delete(post.getId());
         
        return "home";
    }
    
    @RequestMapping(value = "/getPost" , method = RequestMethod.GET)
    public String viewgetPost(@ModelAttribute("postGetForm") PostID postID, Map<String, Object> model) {
        System.out.println(postID);
         
        return "getPost";
    }
    
    @RequestMapping(value = "/getPost", method = RequestMethod.POST)    
    public String viewGetPost(@ModelAttribute("postID") PostID postID, Model m) {    
        Post p = manager.getPostById(postID.getPostID());   
        System.out.println(postID.getPostID());
        System.out.println(p);
        
        m.addAttribute("list",p);  
        return "viewPost";    
    }
}



