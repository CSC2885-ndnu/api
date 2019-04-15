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

import com.notefinder.models.Enrolled;
import com.notefinder.service.EnrolledManager;
import com.notefinder.models.EnrolledAdmin;

@Controller
public class EnrolledController {
	@Autowired    
    EnrolledManager manager;
	
	@RequestMapping(value = "/enrolledadmin/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<EnrolledAdmin>> getEnrolledInfoForAdmin(@PathVariable int id) {
        List<EnrolledAdmin> enrolled = manager.getEnrolledForAdmin(id);
        if(enrolled.isEmpty()){
            return new ResponseEntity<List<EnrolledAdmin>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<EnrolledAdmin>>(enrolled, HttpStatus.OK);
    }
	
	@RequestMapping("/enrolled")
    public String viewpost(Model m) {
    	List<Enrolled> list=manager.getEnrolled();
    	m.addAttribute("list", list);
    	return "enrolled";
    }
    
    @RequestMapping("/home3")
    public String home(Model m) {
    	return "home";
    }
    
    @RequestMapping(value = "/addEnrolled", method = RequestMethod.GET)
    public String viewAddEnrolled(@ModelAttribute("enrolledForm") Enrolled enrolled, Map<String, Object> model) {
    	Enrolled enrolledForm = new Enrolled();
    	model.put("enrolledForm", enrolledForm);
    	System.out.println("IN GET viewAddEnrolled");
    	return "addEnrolled";
    }
    
    @RequestMapping(value = "/addEnrolled", method = RequestMethod.POST)
    public String addEnrolled(@ModelAttribute("enrolledForm") Enrolled enrolled, Map<String, Object> model) {
    	System.out.println("IN POST addEnrolled");
    	manager.save(enrolled);
    	System.out.println("IN POST addEnrolled");
    	return "home";
    }
    
    @RequestMapping(value = "/deleteEnrolled" , method = RequestMethod.GET)
    public String viewdeleteEnrolled(@ModelAttribute("enrolledDeleteForm") Enrolled enrolled, Map<String, Object> model) {
        Enrolled enrolledForm = new Enrolled();    
        model.put("enrolledForm", enrolledForm);
         
        return "deleteEnrolled";
    }
    
    @RequestMapping(value = "/deleteEnrolled" , method = RequestMethod.POST)
    public String deleteEnrolled(@ModelAttribute("enrolledDeleteForm") Enrolled enrolled,
            Map<String, Object> model) {
         
    	manager.delete(enrolled.getCourseID(), enrolled.getUserID());
         
        return "home";
    }

}
