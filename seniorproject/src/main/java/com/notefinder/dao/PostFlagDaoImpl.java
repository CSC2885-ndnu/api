package com.notefinder.dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.notefinder.models.PostFlag;

public class PostFlagDaoImpl implements PostFlagDao {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(PostFlag p) {
		String sql = "insert into post_flag(notes, postID,flagger,flagDate,active) " + "values(" + "'" + p.getNotes()
				+ "'," + p.getPost_id() + "," + p.getFlagger() + "," + p.getDate() + "," + p.isActive() + ")";
		return template.update(sql);
	}

	public int update(PostFlag p) {
		String sql = "update post set postID=" + p.getPost_id() + ", flagger=" + p.getFlagger() + ", flagDate='"
				+ p.getDate() + "', active='" + p.isActive() + "', notes=" + p.getNotes() + " where id="
				+ p.getPost_id();
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from post where id=" + id;
		return template.update(sql);
	}

	public PostFlag getPostFlagById(int id) {
		List<PostFlag> retValue = template.query(
				"select notes,postID,flagger,flagDate,active from post_flag where id=" + id, new RowMapper<PostFlag>() {
					public PostFlag mapRow(ResultSet rs, int row) throws SQLException {
						PostFlag p = new PostFlag();
					    p.setNotes(rs.getString(1));
						p.setPost_id(rs.getInt(2));
						p.setFlagger(rs.getInt(3));
						p.setDate(rs.getTimestamp(4));
						p.setActive(rs.getBoolean(5));
						return p;
					}
				});
		return retValue.get(0);
	}

	public List<PostFlag> getPostFlags() {
		return template.query("select notes,postID,flagger,flagDate,active from post_flag", new RowMapper<PostFlag>() {
			public PostFlag mapRow(ResultSet rs, int row) throws SQLException {
				PostFlag p = new PostFlag();
				p.setNotes(rs.getString(1));
				p.setPost_id(rs.getInt(2));
				p.setFlagger(rs.getInt(3));
				p.setDate(rs.getTimestamp(4));
				p.setActive(rs.getBoolean(5));
				return p;
			}
		});
	}
}
