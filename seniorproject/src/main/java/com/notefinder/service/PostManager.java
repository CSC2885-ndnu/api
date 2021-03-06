package com.notefinder.service;

import java.util.List;


import com.notefinder.models.CommentPostView;
import com.notefinder.models.Post;
import com.notefinder.models.PostLanding;
import com.notefinder.models.PostView;
import com.notefinder.models.PostWithCourseDescription;

public interface PostManager {
	public int save(Post p);
	public int update(Post p);
	public int delete(int id);
	public Post getPostById(int id);
	public List<Post> getPosts();
	public List<PostLanding> getPostsForLanding(int numberOfPosts);
	public List<PostView> getPostsForView(int id);
	public List<CommentPostView> getCommentsForView(int id);
	public List<Post> getCoursePosts(int id);
	public List<PostWithCourseDescription> getPostsForUser(int id);
}
