package tn.esprit.spring.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.Services.ArticleServiceImpl;
import tn.esprit.spring.entity.Article;


@RestController
public class ArticleController {
	@Autowired
	ArticleServiceImpl ArticleService;
	
	@PostMapping("/addArticle")
	@ResponseBody
	public int addArticle(@RequestBody Article a) {
		return ArticleService.addArticle(a);
	}
	
	//http://localhost:8081/SpringMVC/servlet/retrieve-all-articles
	@GetMapping("/retrieve-all-articles")
	@ResponseBody
	public List<Article> getArticles() {
	List<Article> list = ArticleService.retrieveAllArticles();
	 return list;
	}
	
	@DeleteMapping("/deleteArticle/{id_article}") 
	@ResponseBody 
	public void deleteArticle(@PathVariable("id_article") int id) {
		ArticleService.deleteArticle(id);
	}
	
	@PutMapping(value="/UpdateArticle") 
	@ResponseBody
	public void updateArticle(@RequestBody Article a) {
		ArticleService.updateArticle(a);
	}

}
