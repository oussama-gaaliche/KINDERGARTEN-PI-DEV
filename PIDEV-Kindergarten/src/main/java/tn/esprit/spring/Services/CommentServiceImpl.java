package tn.esprit.spring.Services;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.CommentPK;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.Repository.PostRepository;
import tn.esprit.spring.Repository.UserRepository;


@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserRepository userepository;
	@Autowired
	PostRepository postRepository;
	
	String output;
	@Override
	public List<Comment> retrieveComments(Long idPost) {
	List<Comment> c=commentRepository.retrieveComments(idPost);
				return c;
	}
	
	@Override
	public Comment addComment(Long postId, String cmt) {
		

	
		User userrManagedEntity = userepository.findById((long) 1).get();
		Post post = postRepository.findById(postId).get();
		Comment comment = new Comment();
		comment.setUser(userrManagedEntity);
		//comment.setDate(ZonedDateTime.now());
		output = BadWordFilter.getCensoredText(cmt);
		comment.setContained(output);
		comment.setPost(post);
		
		return  commentRepository.save(comment);

	}
	
	



}
