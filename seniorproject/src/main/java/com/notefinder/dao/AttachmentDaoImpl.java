package com.notefinder.dao;

import java.sql.ResultSet;    

import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.Attachment;

 
public class AttachmentDaoImpl implements AttachmentDao
{
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Attachment a) {
		String sql = "insert into attachment(id,post_id,link,type) values(" + a.getId() + "," + a.getPostId() + "," + a.getLink() + "," + a.getType() +  ")";
		return template.update(sql);
	}
	
	public int update(Attachment a) {
		String sql = "update attachment set id=" + a.getId() + ", post_id=" + a.getPostId() + ", link=" + a.getLink() + ", type=" + a.getType() + "";
		return template.update(sql);
	}
	
	public int delete(int id){    
	    String sql="delete from attachment where id="+id+"";    
	    return template.update(sql);    
	} 
	
	public Attachment getAttachmentById(int id){    
	    String sql="select * from attachments where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Attachment>(Attachment.class));    
	}
	
	public List<Attachment> getAttachment(){    
	    return template.query("select * from attachments",new RowMapper<Attachment>(){    
	        public Attachment mapRow(ResultSet rs, int row) throws SQLException {    
	            Attachment a=new Attachment();    
	            a.setId(rs.getInt(1));    
	            a.setPostId(rs.getInt(2));    
	            a.setLink(rs.getString(3));    
	            a.setType(rs.getString(4));  

	            return a;    
	        }    
	    });    
	}

}