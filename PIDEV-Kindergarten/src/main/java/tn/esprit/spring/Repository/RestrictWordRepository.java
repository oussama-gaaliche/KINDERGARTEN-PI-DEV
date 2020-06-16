package tn.esprit.spring.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.RestrictWord;


@Repository
public interface RestrictWordRepository extends CrudRepository<RestrictWord, Integer> {

	public RestrictWord findById(Long id);
	public RestrictWord findByWord(String word);
	public List<RestrictWord> findAll();	
	
}


