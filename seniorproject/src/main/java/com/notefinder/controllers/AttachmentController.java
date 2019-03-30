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

import com.notefinder.dao.AttachmentDao;
import com.notefinder.models.Attachment;
import com.notefinder.models.StudentID;
import com.notefinder.models.User;
import com.notefinder.service.AttachmentManager;


@Controller
public class AttachmentController {
	@Autowired    
    AttachmentManager manager;  
        
    @RequestMapping("/viewAttachment")    
    public String viewAttachment(Model m){   
		List<Attachment> list=manager.getAttachment();
		m.addAttribute("list", list);  
        return "viewAttachment";   
    }     
    
    // Addding Attachments
    @RequestMapping(value = "/addAttachment" , method = RequestMethod.GET)
    public String viewAddUser(@ModelAttribute("attachmentForm") Attachment attachment, Map<String, Object> model) {
    	Attachment attachmentForm = new Attachment();    
        model.put("attachmentForm", attachmentForm);

        return "viewAttachment";
    }
    
    @RequestMapping(value = "/addAttachment" , method = RequestMethod.POST)
    public String addAttachment(@ModelAttribute("attachmentForm") Attachment attachment, Map<String, Object> model) {
         manager.save(attachment);
        return "home";
    }
    
    // Update Attachment
    @RequestMapping(value = "/updateAttachment" , method = RequestMethod.GET)
    public String viewupdateAttachment(@ModelAttribute("attachmentUpdateForm") Attachment attachment, Map<String, Object> model) {
    	Attachment attachmentForm = new Attachment();    
        model.put("attachmentForm", attachmentForm);
                 
        return "updateAttachment";
    }
    
    @RequestMapping(value = "/updateAttachment" , method = RequestMethod.POST)
    public String updateAttachment(@ModelAttribute("attachmentUpdateForm") Attachment attachment,
            Map<String, Object> model) {
         manager.update(attachment);   
        return "home";
    }
    
    // Delete Attachment
    @RequestMapping(value = "/deleteAttachment" , method = RequestMethod.GET)
    public String viewdeleteAttachment(@ModelAttribute("attachmentDeleteForm") Attachment attachment, Map<String, Object> model) {
        Attachment attachmentForm = new Attachment();    
        model.put("attachmentForm", attachmentForm);
                 
        return "deleteAttachment";
    }
    
    @RequestMapping(value = "/deleteAttachment" , method = RequestMethod.POST)
    public String deleteAttachment(@ModelAttribute("attachmentDeleteForm") Attachment attachment,
            Map<String, Object> model) {
         
    	manager.delete(attachment.getId());
         
        return "home";
    }
    
    // Get attachment by studentID
    @RequestMapping(value = "/getAttachment" , method = RequestMethod.GET)
    public String viewGetAttachment(@ModelAttribute("attachmentGetForm") StudentID studentId, Map<String, Object> model) {
        System.out.println(studentId);
         
        return "getAttachment";
    }
    
    @RequestMapping(value = "/getAttachment", method = RequestMethod.POST)    
    public String viewGetUser(@ModelAttribute("attachmentID") StudentID studentID, Model m) {    
        Attachment list= manager.getAttachmentbyId(studentID.getStudentID());   
        System.out.println(studentID.getStudentID());
        System.out.println(list);
        
       m.addAttribute("list",list);  
       
        return "home";    
    }

}