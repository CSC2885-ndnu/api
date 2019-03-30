package com.notefinder.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notefinder.dao.AttachmentDao;
import com.notefinder.models.Attachment;
import com.notefinder.service.AttachmentManager;

@Service("attachmentManager")
public class AttachmentManagerImpl implements AttachmentManager {
	
	@Autowired
	AttachmentDao dao;
	
	public int save(Attachment a) {
		return dao.save(a);
	}
	
	public int update(Attachment a) {
		return dao.update(a);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public Attachment getAttachmentbyId(int id) {
		return dao.getAttachmentById(id);
	}
	
	public List<Attachment> getAttachment() {
		return dao.getAttachment();
	}

	}