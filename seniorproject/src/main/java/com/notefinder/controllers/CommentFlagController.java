package com.notefinder.controllers;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.notefinder.models.CommentFlag;
import com.notefinder.models.CourseId;
import com.notefinder.service.CommentFlagManager;

import java.util.Map;
@Controller    
public class CommentFlagController {    
    @Autowired    
    CommentFlagManager manager;
    
    @RequestMapping("/viewCommentFlags")    
    public String viewpost(Model m){    
        List<CommentFlag> list=manager.getCommentFlags();    
        m.addAttribute("list",list);  
        return "viewCommentFlags";    
    }
    
//    @RequestMapping("/home")    
//    public String home(Model m){    
//        return "home";    
//    }
//    
//    
    @RequestMapping(value = "addCommentFlag" , method = RequestMethod.GET)
    public String viewAddCommentFlag(@ModelAttribute("commentFlagForm") CommentFlag course, Map<String, Object> model) {
        CommentFlag commentFlagForm = new CommentFlag();    
        model.put("commentFlagForm", commentFlagForm);
        
        //int save = manager.save(courseForm);
         System.out.println("This one got called");
         
          CommentFlag c = new CommentFlag();
          
          System.out.println(c);
        return "addCommentFlag";
    }
    
    @RequestMapping(value = "addCommentFlag" , method = RequestMethod.POST)
    public String addCommentFlag(@ModelAttribute("commentFlagForm") CommentFlag cf,
            Map<String, Object> model) {
         
    	manager.save(cf);
    	System.out.println(cf);
         
        return "home";
    }
    
    @RequestMapping(value = "/editCommentFlag" , method = RequestMethod.GET)
    public String viewupdateCourse(@ModelAttribute("commentFlagUpdateForm") CommentFlag commentFlag, Map<String, Object> model) {
        CommentFlag commentFlagForm = new CommentFlag();    
        model.put("commentFlagUpdateForm", commentFlagForm);
        
        //int save = manager.save(courseForm);
         
        return "editCommentFlag";
    }
    
    @RequestMapping(value = "/editCommentFlag" , method = RequestMethod.POST)
    public String updateCourse(@ModelAttribute("commentFlagUpdateForm") CommentFlag commentFlag,
            Map<String, Object> model) {
          System.out.println(commentFlag);
    	manager.update(commentFlag);
         
        return "home";
    }
    
    @RequestMapping(value = "/deleteCommentFlag" , method = RequestMethod.GET)
    public String viewdeleteCommentFlag(@ModelAttribute("commentFlagDeleteForm") CommentFlag commentFlag, Map<String, Object> model) {
    	CommentFlag commentFlagForm = new CommentFlag();    
        model.put("commentFlagDeleteForm", commentFlagForm);
        
        //int save = manager.save(courseForm);
         
        return "deleteCommentFlag";
    }
    
    @RequestMapping(value = "/deleteCommentFlag" , method = RequestMethod.POST)
    public String deleteCommentFlag(@ModelAttribute("commentFlagDeleteForm") CommentFlag commentFlag,
            Map<String, Object> model) {
         
    	manager.delete(commentFlag.getId());
    	System.out.println("deleted id: " + commentFlag.getId());
         
        return "home";
    }
    
    @RequestMapping(value = "/getCommentFlag" , method = RequestMethod.GET)
    public String viewgetCommentFlag(@ModelAttribute("commentFlagGetForm") CourseId course_id, Map<String, Object> model) {
        System.out.println(course_id);
//    	Course courseForm = manager.getCourseById(course_id.getCourse_id());    
//        model.put("courseForm", courseForm );
        
        //int save = manager.save(courseForm);
         
        return "getCommentFlag";
    }  

    @RequestMapping(value = "/getCommentFlag", method = RequestMethod.POST)    
    public String viewGetCommentFlag(@ModelAttribute("course_id") CourseId course_id, Model m) {    
        List<CommentFlag> list=manager.getCommentFlagById(course_id.getCourse_id());   
        System.out.println(course_id.getCourse_id());
        System.out.println(list);
        
        m.addAttribute("list",list);  
        return "viewCommentFlag";    
    }
    
    
}

