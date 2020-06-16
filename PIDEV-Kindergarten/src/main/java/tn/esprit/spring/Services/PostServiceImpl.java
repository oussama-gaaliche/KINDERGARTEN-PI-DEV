package tn.esprit.spring.Services;

import java.time.ZonedDateTime;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.PostReport;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.Repository.CommentRepository;
import tn.esprit.spring.Repository.PostReportRepository;
import tn.esprit.spring.Repository.PostRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.Repository.WordCountRepository;

@Service
@Transactional

public class PostServiceImpl implements IPostService {

	@Autowired
	UserRepository userrepository;
	@Autowired
	PostRepository postRepository;
	@Autowired
	CommentRepository commentRepository;
	private String output;
	
	@Autowired
	PostReportRepository postreportRepository;
	@Autowired
	WordCountRepository countRepository;


	@Override
	public List<Post> retrieveAllPost() {
	return	(List<Post>) postRepository.findAll();


	
	}

	@Override

	public Post save(Post post) {
		
		
		
		return postRepository.save(post);
	}

	@Override
	public Post addPost(Post p) {
		
		User userManagedEntity = userrepository.findById((long) 1).get();

		Post post = new Post();
		post.setUser(userManagedEntity);
		post.setDate(ZonedDateTime.now());
		output = BadWordFilter.getCensoredText(p.getContained());
		post.setContained(output);
		post.setLikeCount(0);
		return postRepository.save(post);
		
	
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);

	}
	@Override
	public List<Comment> retrieveComments(Long idPost) {
	List<Comment> c=commentRepository.retrieveComments(idPost);
				return c;
	}
	@Override
	public Comment addComment(Long postId, String cmt) {
		

	
		User userrManagedEntity = userrepository.findById((long) 1).get();
		Post post = postRepository.findById(postId).get();
		Comment comment = new Comment();
		comment.setUser(userrManagedEntity);
		//comment.setDate(ZonedDateTime.now());
		output = BadWordFilter.getCensoredText(cmt);
		comment.setContained(output);
		comment.setPost(post);
		
		return  commentRepository.save(comment);

	}
	

	@Override
	public Post updatePost(Post p) {

		return postRepository.save(p);
	}

	@Override
	public Post retrievePost(Long id) {
		Post p = postRepository.findById((id)).orElse(null);
		return p;
	}
	@Override
	public PostReport addReport(PostReport p, long id) {
		
		User userManagedEntity = userrepository.findById((long) 1).get();
		Post post = postRepository.findById(id).get();

		PostReport report = new PostReport();
		report.setUser(userManagedEntity);
		report.setPost(post);
		report.setMessage(p.getMessage());
		
	
		

		return postreportRepository.save(report);
		
	
	}

	@Override
	public PostReport addReport(PostReport p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
public List<?> listPostc() {

		
		return postRepository.listPostc();
		
		}
public List<?> listPostcc() {

	
	return commentRepository.listPostcc();
	
	}


public List<?> listPostt() {

	
	return postRepository.listPostt();
	
	}



public List<?> listPostm() {

	
	return postRepository.listPostm();
	
	}
public List<?>  listcountm() {

	
	return countRepository.listcountm();
	
	}

}
