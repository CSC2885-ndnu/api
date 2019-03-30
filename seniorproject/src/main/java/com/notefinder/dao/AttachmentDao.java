package com.notefinder.dao;

import java.sql.ResultSet;




import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.Attachment;
import com.notefinder.dao.AttachmentDaoImpl;

public interface AttachmentDao {
	public int save(Attachment a);
	public int update(Attachment a);
	public int delete(int id);
	public Attachment getAttachmentById(int id);
	public List<Attachment> getAttachment();
}
