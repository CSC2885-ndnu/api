package com.notefinder.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.notefinder.models.Post;
import com.notefinder.models.PostLanding;
import com.notefinder.models.PostView;
import com.notefinder.models.CommentPostView;

public class PostDaoImpl implements PostDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Post p) {
		String sql = "insert into post(title,courseID,postDate,note,userID,flagged) values('" + p.getTitle() + "',"
				+ p.getCourseID() + ", now(), '" + p.getNote() + "'," + p.getUserID() + "," + p.isFlagged() + ")";
		return template.update(sql);
	}

	public int update(Post p) {
		String sql = "update post set id=" + p.getId() + ", title='" + p.getTitle() + "', courseID=" + p.getCourseID()
				+ ", postDate=now()" + ", note='" + p.getNote() + "', userID=" + p.getUserID() + ", flagged="
				+ p.isFlagged() + " where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from post where id=" + id + "";
		return template.update(sql);
	}

	public Post getPostById(int id) {
		String sql = "select * from post where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Post>(Post.class));
	}

	public List<Post> getPosts() {
		return template.query("select * from post", new RowMapper<Post>() {
			public Post mapRow(ResultSet rs, int row) throws SQLException {
				Post p = new Post();
				p.setId(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setCourseID(rs.getInt(3));
				p.setPostDate(rs.getTimestamp(4));
				p.setNote(rs.getString(5));
				p.setUserID(rs.getInt(6));
				p.setFlagged(rs.getBoolean(7));
				return p;
			}
		});
	}

	public List<PostLanding> getPostsForLanding(int numberOfPosts) {
		return template
				.query("select p.id, p.title, c.name, p.postDate from post p, course c where p.courseID = c.id limit "
						+ numberOfPosts, new RowMapper<PostLanding>() {
							public PostLanding mapRow(ResultSet rs, int row) throws SQLException {
								PostLanding p = new PostLanding();
								p.setId(rs.getInt(1));
								p.setSubmission_title(rs.getString(2));
								p.setSubmission_course_name(rs.getString(3));
								p.setSubmission_date(rs.getTimestamp(4));
								return p;
							}
						});
	}

	public List<PostView> getPostsForView(int id) {
		return template.query(
				"select p.id, p.title, c.name, c.meetingDay, p.postDate, p.note, u.firstName from post p, course c, user u where p.id ="
						+ id + " and p.courseID = c.id and p.userID = u.id;",
				new RowMapper<PostView>() {
					public PostView mapRow(ResultSet rs, int row) throws SQLException {
						PostView p = new PostView();
						p.setId(rs.getInt(1));
						p.setTitle(rs.getString(2));
						p.setCourse_name(rs.getString(3));
						p.setClass_date(rs.getString(4));
						p.setPost_created_date(rs.getTimestamp(5));
						p.setNote(rs.getString(6));
						p.setUser(rs.getString(7));
						return p;
					}
				});
	}

	public List<CommentPostView> getCommentsForView(int id) {
		return template
				.query("select c.id, c.comment, p.postDate, u.firstName from comment c, post p, user u where p.id = "
						+ id + " and c.postID = p.id and c.userID = u.id;", new RowMapper<CommentPostView>() {
							public CommentPostView mapRow(ResultSet rs, int row) throws SQLException {
								CommentPostView c = new CommentPostView();
								c.setCommentID(rs.getInt(1));
								c.setText(rs.getString(2));
								c.setPostDate(rs.getTimestamp(3));
								c.setAuthor(rs.getString(4));
								return c;

							}
						});
	}
	
	public List<Post> getCoursePosts(int id){
	    return template.query("select id, title, courseID, postDate, note, userID, flagged from post where courseID=" + id,new RowMapper<Post>(){    
	        public Post mapRow(ResultSet rs, int row) throws SQLException {    
	            Post p=new Post();    
	            p.setId(rs.getInt(1));    
	            p.setTitle(rs.getString(2));    
	            p.setCourseID(rs.getInt(3));  
	            p.setPostDate(rs.getTimestamp(4));
	            p.setNote(rs.getString(5));
	            p.setUserID(rs.getInt(6));
	            p.setFlagged(rs.getBoolean(7));
	            return p;    
	        }    
	    });
	}
	
	public List<Post> getPostsForUser(int id)
	{
	    return template.query("select id, title, courseID, postDate, note, userID, flagged from post where userId=" + id,new RowMapper<Post>(){    
	        public Post mapRow(ResultSet rs, int row) throws SQLException {    
	            Post p=new Post();    
	            p.setId(rs.getInt(1));    
	            p.setTitle(rs.getString(2));    
	            p.setCourseID(rs.getInt(3));  
	            p.setPostDate(rs.getTimestamp(4));
	            p.setNote(rs.getString(5));
	            p.setUserID(rs.getInt(6));
	            p.setFlagged(rs.getBoolean(7));
	            return p;    
	        }    
	    });
	}
}
