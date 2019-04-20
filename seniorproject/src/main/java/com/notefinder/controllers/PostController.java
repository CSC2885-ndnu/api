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

import com.notefinder.models.Post;
import com.notefinder.models.PostID;
import com.notefinder.service.PostManager;
import com.notefinder.models.PostLanding;
import com.notefinder.models.PostView;

@Controller    
public class PostController {    
    @Autowired    
    PostManager manager;

    @RequestMapping(value = "/getCoursePosts/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Post>> getCoursePosts(@PathVariable int id) {
        List<Post> posts = manager.getCoursePosts(id);
        if(posts.isEmpty()){
            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getUserPosts/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Post>> getUserPosts(@PathVariable int id) {
        List<Post> posts = manager.getPostsForUser(id);
        if(posts.isEmpty()){
            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/landingpage/{numberOfPosts}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<PostLanding>> getPostInfoForLanding(@PathVariable int numberOfPosts) {
        List<PostLanding> posts = manager.getPostsForLanding(numberOfPosts);
        if(posts.isEmpty()){
            return new ResponseEntity<List<PostLanding>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PostLanding>>(posts, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/viewpostpage/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<PostView> getPostsForView(@PathVariable int id) {
        List<PostView> posts = manager.getPostsForView(id);
        PostView postView = posts.get(0);
        postView.setCommentList(manager.getCommentsForView(id));
        if(posts.isEmpty()){
            return new ResponseEntity<PostView>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<PostView>(postView, HttpStatus.OK);
    }
    
    @RequestMapping("/posts")
    public String viewpost(Model m) {
    	List<Post> list=manager.getPosts();
    	m.addAttribute("list", list);
    	return "posts";
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
    
    @RequestMapping(value="/editPost/{id}")
    public String edit(@PathVariable int id, Model m) {
    	Post post=manager.getPostById(id);
    	m.addAttribute("command", post);
    	return "editPostForm";
    }
    
    @RequestMapping(value="/editSavePost", method=RequestMethod.POST)
    public String editsave(@ModelAttribute("post") Post post) {
    	manager.update(post);
    	return "redirect:/posts";
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
        return "getPost";
    }
    
    @RequestMapping(value = "/getPost", method = RequestMethod.POST)    
    public String viewGetPost(@ModelAttribute("postID") PostID postID, Model m) {    
        Post post=manager.getPostById(postID.getPostID());
        m.addAttribute("post", post);
        return "viewPost";    
    }
}



