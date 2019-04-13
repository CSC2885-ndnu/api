package com.notefinder.service;

import java.util.List;
import com.notefinder.models.Post;
import com.notefinder.models.PostLanding;

public interface PostManager {
	public int save(Post p);
	public int update(Post p);
	public int delete(int id);
	public Post getPostById(int id);
	public List<Post> getPosts();
	public List<PostLanding> getPostsForLanding(int numberOfPosts);
	public List<Post> getPostsForUser(int id);
	public List<Post> getCoursePosts(int id);
}
