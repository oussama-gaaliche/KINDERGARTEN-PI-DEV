package tn.esprit.spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.PostReport;


@Repository
public interface PostReportRepository extends JpaRepository <PostReport,Long> {

}
