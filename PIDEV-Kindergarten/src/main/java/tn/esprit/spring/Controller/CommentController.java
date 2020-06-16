package tn.esprit.spring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.services.ICommentService;
@RestController

public class CommentController {
	@Autowired
	ICommentService commentService;
	
	
	
	
	@GetMapping("/retrieve-comments/{idPost}")
	@ResponseBody
	public List<Comment> retrievePost(@PathVariable("idPost") Long idPost) {
	return commentService.retrieveComments(idPost);
	}

}
