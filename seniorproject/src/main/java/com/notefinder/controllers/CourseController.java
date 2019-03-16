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
import com.notefinder.models.CourseId;
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
    
    
    @RequestMapping(value = "/addCourse" , method = RequestMethod.GET)
    public String viewAddCourse(@ModelAttribute("courseForm") Course course, Map<String, Object> model) {
        Course courseForm = new Course();    
        model.put("courseForm", courseForm);
        
        //int save = manager.save(courseForm);
         
        return "addCourse";
    }
    
    @RequestMapping(value = "/addCourse" , method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("courseForm") Course course,
            Map<String, Object> model) {
         
    	int save = manager.save(course);
         
        return "home";
    }
    
    @RequestMapping(value = "/updateCourse" , method = RequestMethod.GET)
    public String viewupdateCourse(@ModelAttribute("courseUpdateForm") Course course, Map<String, Object> model) {
        Course courseForm = new Course();    
        model.put("courseForm", courseForm);
        
        //int save = manager.save(courseForm);
         
        return "updateCourse";
    }
    
    @RequestMapping(value = "/updateCourse" , method = RequestMethod.POST)
    public String updateCourse(@ModelAttribute("courseUpdateForm") Course course,
            Map<String, Object> model) {
         
    	int update = manager.update(course);
         
        return "home";
    }
    
    @RequestMapping(value = "/deleteCourse" , method = RequestMethod.GET)
    public String viewdeleteCourse(@ModelAttribute("courseDeleteForm") Course course, Map<String, Object> model) {
        Course courseForm = new Course();    
        model.put("courseForm", courseForm);
        
        //int save = manager.save(courseForm);
         
        return "deleteCourse";
    }
    
    @RequestMapping(value = "/deleteCourse" , method = RequestMethod.POST)
    public String deleteCourse(@ModelAttribute("courseDeleteForm") Course course,
            Map<String, Object> model) {
         
    	int update = manager.delete(course.getCourse_id());
         
        return "home";
    }
    
    @RequestMapping(value = "/getCourse" , method = RequestMethod.GET)
    public String viewgetCourse(@ModelAttribute("courseGetForm") CourseId course_id, Map<String, Object> model) {
        System.out.println(course_id);
//    	Course courseForm = manager.getCourseById(course_id.getCourse_id());    
//        model.put("courseForm", courseForm );
        
        //int save = manager.save(courseForm);
         
        return "getCourse";
    }
//    @RequestMapping(value = "/getCourse" , method = RequestMethod.GET)
//    public String viewgetCourse(@RequestParam("course_id") int course_id, Map<String, Object> model) {
//        System.out.println(course_id);
//    	Course courseForm = manager.getCourseById(course_id);    
//        model.put("courseForm", courseForm );
//        
//        //int save = manager.save(courseForm);
//         
//        return "getCourse";
//    }
    
    
//    @RequestMapping(value = "/getCourse" , method = RequestMethod.POST)
//    public String getCourse(@ModelAttribute("course_id") CourseId course_id,
//            Map<String, Object> model) {
//    	System.out.println(course_id);
//    	Course courseForm = manager.getCourseById(course_id.getCourse_id());    
//        model.put("courseForm", courseForm );
//    	//int update = manager.delete(course.getCourse_id());
//    	//Course get = manager.getCourseById(course);
//    	//.put("courseGetForm", get);
//         
//        return "viewCourse";
//    }
//    
    @RequestMapping(value = "/getCourse", method = RequestMethod.POST)    
    public String viewGetCourse(@ModelAttribute("course_id") CourseId course_id, Model m) {    
        List<Course> list=manager.getCourseById(course_id.getCourse_id());   
        System.out.println(course_id.getCourse_id());
        System.out.println(list);
        
        m.addAttribute("list",list);  
        return "viewCourse";    
    }
    
    
}
