package com.notefinder.dao;

import java.sql.ResultSet;    


import java.sql.SQLException;    
import java.util.List;    
import org.springframework.jdbc.core.BeanPropertyRowMapper;    
import org.springframework.jdbc.core.JdbcTemplate;    
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.Attachments;

 
public class AttachmentDaoImpl implements AttachmentDao
{
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int save(Attachments a) {
		String sql = "insert into attachments ( postId, link, type)" + "values("  + a.getPostId() + ",'" + a.getLink() + "','" + a.getType() +  "')";
		return template.update(sql);
	}
	
	public int update(Attachments a) {
		String sql = "update attachments set postId=" + a.getPostId() + ", link='" + a.getLink() + "', type='" + a.getType() + "' where id =" + a.getId() ;
		return template.update(sql);
	}
	
	public int delete(int id){    
	    String sql="delete from attachments where id="+id+"";    
	    return template.update(sql);    
	} 
	
	public Attachments getAttachmentById(int id){    
	    String sql="select * from attachments where id=?";    
	    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Attachments>(Attachments.class));    
	}
	
	public List<Attachments> getAttachment(){    
	    return template.query("select * from attachments",new RowMapper<Attachments>(){    
	        public Attachments mapRow(ResultSet rs, int row) throws SQLException {    
	            Attachments a=new Attachments();    
	            a.setId(rs.getInt(1));    
	            a.setPostId(rs.getInt(2));    
	            a.setLink(rs.getString(3));    
	            a.setType(rs.getString(4));  

	            return a;    
	        }    
	    });    
	}

}