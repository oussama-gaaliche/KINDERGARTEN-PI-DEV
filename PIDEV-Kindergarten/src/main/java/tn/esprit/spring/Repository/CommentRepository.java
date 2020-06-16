package tn.esprit.spring.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Post;

@Repository
public interface CommentRepository extends JpaRepository <Comment,Long> {
	
	@Query("SELECT c FROM Comment c WHERE c.post.id= :idPost  ")
	
	List<Comment> retrieveComments(@Param("idPost") Long idPost);
	@Query("select count (*)  from Comment ")
	public List<?> listPostcc();

}
