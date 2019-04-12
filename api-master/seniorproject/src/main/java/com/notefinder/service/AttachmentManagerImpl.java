package com.notefinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.AttachmentDao;
import com.notefinder.models.Attachments;
import com.notefinder.service.AttachmentManager;

@Service("attachmentManager")
public class AttachmentManagerImpl implements AttachmentManager {
	
	@Autowired
	AttachmentDao dao;
	
	public int save(Attachments a) {
		return dao.save(a);
	}
	
	public int update(Attachments a) {
		return dao.update(a);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public Attachments getAttachmentById(int id) {
		return dao.getAttachmentById(id);
	}
	
	public List<Attachments> getAttachments() {
		return dao.getAttachment();
	}


	}