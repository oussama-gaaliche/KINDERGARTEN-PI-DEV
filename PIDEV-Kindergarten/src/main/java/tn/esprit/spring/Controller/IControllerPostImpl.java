package tn.esprit.spring.Controller;

import java.util.List;

import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.Services.ICommentService;
import tn.esprit.spring.Services.IPostService;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;

@Scope(value = "session")
@Controller(value = "PostController")
@ELBeanName(value = "PostController")
@Join(path = "/", to = "/post.jsf")

public class IControllerPostImpl {
	@Autowired
	IPostService postservice;
	@Autowired
	IPostService commentservice;
	
	private String contained;
	private String cmt;
	private Long postId;

	private List<Post> posts;
	private List<Comment> comments;
	

	public void addPost() {

		postservice.addPost(new Post(contained, null, null, 0,null));
	}

	public String getContained() {
		return contained;
	}

	public void setContained(String contained) {
		this.contained = contained;
	}

	public void setPost(List<Post> post) {
		this.posts = post;
	}

	public List<Post> getPosts() {
		posts = postservice.retrieveAllPost();

		return posts;
	}

	public List<Comment> getComments(Long id) {
		comments = commentservice.retrieveComments(id);
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}
	
	
	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public void addcomment(Long postId,String cmt) {

		commentservice.addComment(postId,cmt);
		
	}
public List<?> listPostc() {

		
		return postservice.listPostc();
		
		}
public List<?> listPostcc() {

	
	return postservice.listPostcc();
	
	}
public List<?> listPostt() {

	
	return postservice.listPostt();
	
	}
public List<?> listPostm() {

	
	return postservice.listPostm();
	
	}
public List<?> listcountm(){

	
	return postservice.listcountm();
	
	}


}
