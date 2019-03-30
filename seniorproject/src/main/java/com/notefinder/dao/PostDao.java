package com.notefinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.dao.PostDaoImpl;
import com.notefinder.models.Post; 

public interface PostDao {
	public int save(Post p);
	public int update(Post p);
	public int delete(int id);
	public Post getPostById(int id);
	public List<Post> getPosts();
}
