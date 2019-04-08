package com.notefinder.service;

import java.util.List;

import com.notefinder.models.Attachments;

public interface AttachmentManager {
	public int save(Attachments a);
	public int update(Attachments a);
	public int delete(int id);
	public Attachments getAttachmentById(int id);
	public List<Attachments> getAttachments();
}
