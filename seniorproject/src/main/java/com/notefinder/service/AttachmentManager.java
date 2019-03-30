package com.notefinder.service;

import java.util.List;


import com.notefinder.models.Attachment;

public interface AttachmentManager {
	public int save(Attachment a);
	public int update(Attachment a);
	public int delete(int id);
	public Attachment getAttachmentbyId(int id);
	public List<Attachment> getAttachment();
}
