package tn.esprit.spring.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;

public interface ICommentService {

	List<Comment>  retrieveComments(Long idPost);

	Comment addComment(Long postId,String cmt);
	

	
	

}
