package tn.esprit.spring.Services;

import java.util.List;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.PostReport;
import tn.esprit.spring.entity.User;

public interface IPostService {
	List<Post> retrieveAllPost();
	Post save(Post post);
	Post addPost(Post p);
	void deletePost(Long id);
	Post updatePost(Post p);
	Post retrievePost(Long id);
	PostReport addReport(PostReport p);
	PostReport addReport(PostReport p, long id);
	List<?> listPostc();
	List<?> listPostcc();
	List<?> listPostt();
	List<?> listPostm();
	List<?> listcountm();
	Comment addComment(Long postId, String cmt);
	List<Comment> retrieveComments(Long idPost);
	


}
