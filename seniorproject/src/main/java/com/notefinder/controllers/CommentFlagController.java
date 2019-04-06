package com.notefinder.controllers;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import com.notefinder.models.CommentFlag;
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
//    
//    @RequestMapping(value = "/updateCourse" , method = RequestMethod.GET)
//    public String viewupdateCourse(@ModelAttribute("courseUpdateForm") Course course, Map<String, Object> model) {
//        Course courseForm = new Course();    
//        model.put("courseForm", courseForm);
//        
//        //int save = manager.save(courseForm);
//         
//        return "updateCourse";
//    }
//    
//    @RequestMapping(value = "/updateCourse" , method = RequestMethod.POST)
//    public String updateCourse(@ModelAttribute("courseUpdateForm") Course course,
//            Map<String, Object> model) {
//         
//    	int update = manager.update(course);
//         
//        return "home";
//    }
//    
//    @RequestMapping(value = "/deleteCourse" , method = RequestMethod.GET)
//    public String viewdeleteCourse(@ModelAttribute("courseDeleteForm") Course course, Map<String, Object> model) {
//        Course courseForm = new Course();    
//        model.put("courseForm", courseForm);
//        
//        //int save = manager.save(courseForm);
//         
//        return "deleteCourse";
//    }
//    
//    @RequestMapping(value = "/deleteCourse" , method = RequestMethod.POST)
//    public String deleteCourse(@ModelAttribute("courseDeleteForm") Course course,
//            Map<String, Object> model) {
//         
//    	int update = manager.delete(course.getCourse_id());
//         
//        return "home";
//    }
//    
//    @RequestMapping(value = "/getCourse" , method = RequestMethod.GET)
//    public String viewgetCourse(@ModelAttribute("courseGetForm") CourseId course_id, Map<String, Object> model) {
//        System.out.println(course_id);
////    	Course courseForm = manager.getCourseById(course_id.getCourse_id());    
////        model.put("courseForm", courseForm );
//        
//        //int save = manager.save(courseForm);
//         
//        return "getCourse";
//    }  
//
//    @RequestMapping(value = "/getCourse", method = RequestMethod.POST)    
//    public String viewGetCourse(@ModelAttribute("course_id") CourseId course_id, Model m) {    
//        List<Course> list=manager.getCourseById(course_id.getCourse_id());   
//        System.out.println(course_id.getCourse_id());
//        System.out.println(list);
//        
//        m.addAttribute("list",list);  
//        return "viewCourse";    
//    }
    
    
}

