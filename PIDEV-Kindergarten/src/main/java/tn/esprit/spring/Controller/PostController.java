package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import tn.esprit.spring.entity.Comment;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.Services.ICommentService;
import tn.esprit.spring.Services.IPostService;

@RestController
public class PostController {


	@Autowired
	IPostService postService;
	
	@Autowired
	ICommentService commentService;
	
	 // http://localhost:8081/SpringMVC/servlet/retrieve-all-post
	 @GetMapping("/retrieve-All-Post")
	 @ResponseBody
	 public List<Post> getPosts() {
	 List<Post> list = postService.retrieveAllPost();
	 return list;
	 
	 
	// Ajouter User : http://localhost:8081/SpringMVC/servlet/add-user
	 
	 }
	 
	 @PostMapping("/add-post")
	 @ResponseBody
		  public Post addPost(@RequestBody Post post) {
		Post poste = postService.addPost(post);
		  return poste;
		  } 
	 
	 
	//http://localhost:8081/SpringMVC/servlet/remove-post/1
		@DeleteMapping("/remove-post/{id}")
		@ResponseBody
		public void removePost(@PathVariable("id") Long id) {
		postService.deletePost(id);
		 }
		 //http://localhost:8081/SpringMVC/servlet/modify-post
		@PutMapping("/modify-post")
		@ResponseBody
		public Post modifyPost(@RequestBody Post post) {
		return postService.updatePost(post);
		 }
		
		//http://localhost:8081/SpringMVC/servlet/retrieve-post/1
		@GetMapping("/retrieve-post/{id}")
		@ResponseBody
		public Post retrievePost(@PathVariable("id") Long id) {
		return postService.retrievePost(id);
		}
		
		@PostMapping("/add-report")
		 @ResponseBody
			  public Post addRport(@RequestBody Post post, long id) {
			Post poste = postService.addPost(post);
			  return poste;
			  } 
	
	 

}
	


