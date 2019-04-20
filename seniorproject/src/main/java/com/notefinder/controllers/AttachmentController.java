package com.notefinder.controllers;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;    
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping;    
import org.springframework.web.bind.annotation.RequestMethod;   

import com.notefinder.models.Attachments;
import com.notefinder.service.AttachmentManager;

@Controller
public class AttachmentController {
	@Autowired    
    AttachmentManager manager;  
        
    @RequestMapping("/viewAttachment")    
    public String viewattachment(Model m){   
		List<Attachments> list=manager.getAttachments();
		m.addAttribute("list", list);  
        return "viewAttachment";   
    }     
    @RequestMapping(value = "/addAttachment" , method = RequestMethod.GET)
    public String viewAddAttachment(@ModelAttribute("attachmentForm") Attachments attachments, Map<String, Object> model) {
    	Attachments attachmentForm = new Attachments();    
        model.put("attachmentForm", attachmentForm);
        return "addAttachment";
    }
    
    @RequestMapping(value = "/addAttachment" , method = RequestMethod.POST)
    public String addAttachments(@ModelAttribute("addAttachmentForm") Attachments attachments, Map<String, Object> model) {
    	manager.save(attachments);
        return "redirect:/viewAttachment";
    }
    
    @RequestMapping(value = "/updateAttachment" , method = RequestMethod.GET)
    public String viewupdateAttachment(@ModelAttribute("attachmentUpdateForm") Attachments attachments, Map<String, Object> model) {
        Attachments attachmentForm = new Attachments();    
        model.put("attachmentForm", attachmentForm);
         
        return "updateAttachment";
    }
    
    @RequestMapping(value = "/updateAttachment" , method = RequestMethod.POST)
    public String updateAttachment(@ModelAttribute("attachmentUpdateForm") Attachments attachments,
            Map<String, Object> model) {
         
      manager.update(attachments);
         
        return "redirect:/viewAttachment";
    }
   
   @RequestMapping(value = "/deleteAttachment" , method = RequestMethod.GET)
   public String viewdeleteAttachment(@ModelAttribute("attachmentDeleteForm") Attachments attachments, Map<String, Object> model) {
       Attachments attachmentForm = new Attachments();    
       model.put("attachmentForm", attachmentForm);
                
       return "deleteAttachment";
   }
   
   @RequestMapping(value = "/deleteAttachment" , method = RequestMethod.POST)
   public String deleteAttachment(@ModelAttribute("attachmentDeleteForm") Attachments attachments, Map<String, Object> model) {   
   	manager.delete(attachments.getId());
        
       return "redirect:/viewAttachment";
   }
   
}