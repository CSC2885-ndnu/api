 package com.notefinder.dao;

import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.Attachments;
import com.notefinder.dao.AttachmentDaoImpl;

public interface AttachmentDao {
    public int save(Attachments a);
    public int update(Attachments a);
    public int delete(int id);
    public Attachments getAttachmentById(int id);
    public List<Attachments> getAttachment();
}