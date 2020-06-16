package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import tn.esprit.spring.entity.Post;

@Repository
public interface PostRepository extends JpaRepository <Post,Long> {

	@Query("select count (*)  from Post ")
	public List<?> listPostc();
	@Query("select count (*)  from Post where date =CURDATE() ")
	public List<?> listPostt();
	@Query("select count(*) from Post where MONTH(date) = MONTH(CURDATE())")
	public List<?> listPostm();
}
