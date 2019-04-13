package com.notefinder.controllers;  
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute;   
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.notefinder.models.Course; 
import com.notefinder.models.CourseId;
import com.notefinder.models.User;
import com.notefinder.service.CourseManager;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Controller    
public class CourseController {    
    @Autowired    
    CourseManager manager;
    
    @RequestMapping(value = "/coursesjson/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Course>> listAllUsers() {
        List<Course> courses = manager.getCourse();
        if(courses.isEmpty()){
            return new ResponseEntity<List<Course>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getUserCourses/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> getUserCourses(@PathVariable("id") int id) {
        System.out.println("Fetching Courses with id " + id);
        List<Course> courses = manager.getUserCourses(id);
        if (courses == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<List<Course>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/getCourseStudents/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getCourseStudents(@PathVariable("id") int id) {
        List<User> courses = manager.getCourseStudents(id);
        if (courses == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<User>>(courses, HttpStatus.OK);
    }
    
    @RequestMapping("/courses")    
    public String viewpost(Model m){    
        List<Course> list=manager.getCourse();    
        m.addAttribute("list",list);  
        return "courses";    
    }
    
    @RequestMapping("/home2")    
    public String home(Model m){    
        return "home";    
    }
    
    @RequestMapping(value = "/addCourse" , method = RequestMethod.GET)
    public String viewAddCourse(@ModelAttribute("courseForm") Course course, Map<String, Object> model) {
        Course courseForm = new Course();    
        model.put("courseForm", courseForm);
         
        return "addCourse";
    }
    
	@RequestMapping(value = "/addCourse" , method = RequestMethod.POST)
    public String addCourse(@ModelAttribute("courseForm") Course course,
            Map<String, Object> model) {
         
    	manager.save(course);
         
        return "home";
    }
    
    @RequestMapping(value = "/updateCourse" , method = RequestMethod.GET)
    public String viewupdateCourse(@ModelAttribute("courseUpdateForm") Course course, Map<String, Object> model) {
        Course courseForm = new Course();    
        model.put("courseForm", courseForm);
         
        return "updateCourse";
    }
    
    @RequestMapping(value = "/updateCourse" , method = RequestMethod.POST)
    public String updateCourse(@ModelAttribute("courseUpdateForm") Course course,
            Map<String, Object> model) {
         
    	manager.update(course);
         
        return "home";
    }
    
    @RequestMapping(value = "/deleteCourse" , method = RequestMethod.GET)
    public String viewdeleteCourse(@ModelAttribute("courseDeleteForm") Course course, Map<String, Object> model) {
        Course courseForm = new Course();    
        model.put("courseForm", courseForm);
         
        return "deleteCourse";
    }
    
    @RequestMapping(value = "/deleteCourse" , method = RequestMethod.POST)
    public String deleteCourse(@ModelAttribute("courseDeleteForm") Course course,
            Map<String, Object> model) {
         
    	manager.delete(course.getCourse_id());
         
        return "home";
    }
    
    @RequestMapping(value = "/getCourse" , method = RequestMethod.GET)
    public String viewgetCourse(@ModelAttribute("courseGetForm") CourseId course_id, Map<String, Object> model) {
        System.out.println(course_id);

         
        return "getCourse";
    }  

    @RequestMapping(value = "/getCourse", method = RequestMethod.POST)    
    public String viewGetCourse(@ModelAttribute("course_id") CourseId course_id, Model m) {    
        List<Course> list=manager.getCourseById(course_id.getCourse_id());   
        System.out.println(course_id.getCourse_id());
        System.out.println(list);
        
        m.addAttribute("list",list);  
        return "viewCourse";    
    }
    
    
}

