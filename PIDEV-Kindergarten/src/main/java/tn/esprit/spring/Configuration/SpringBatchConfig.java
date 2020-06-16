package tn.esprit.spring.Configuration;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import tn.esprit.spring.batch.ArticleItemProcessor;
import tn.esprit.spring.entity.Article;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	@Autowired
	public DataSource dataSource;
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	public DataSource dataSource(){
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		System.out.println("in data source driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/kindergarten");
		System.out.println("in data source url");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public JdbcCursorItemReader<Article> reader(){
		JdbcCursorItemReader<Article> reader = new JdbcCursorItemReader<Article>();
		reader.setDataSource(dataSource);
		reader.setSql("select id_article,nom from article;");
		reader.setRowMapper(new ArticleRowMapper());
		return reader;
		  
	}
	
	public class ArticleRowMapper implements RowMapper<Article>{

		@Override
		public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
			Article article=new Article();
			article.setId_article(rs.getLong("id_article"));
			article.setNom(rs.getString("nom"));
			return article;
		}
		
	}
	
	public ArticleItemProcessor processor(){
		return new ArticleItemProcessor();
	}
	
	@Bean
	public FlatFileItemWriter<Article> writer(){
		FlatFileItemWriter<Article> writer = new FlatFileItemWriter<Article>();
		writer.setResource(new ClassPathResource("article.csv"));
		writer.setLineAggregator(new DelimitedLineAggregator<Article>(){{
			setDelimiter(",");
			setFieldExtractor(new BeanWrapperFieldExtractor<Article>(){{
				setNames(new String[] {"id_article","nom"});
			}});
		}});
		return writer;
	}
	
	@Bean
	public Step step1(){
		return stepBuilderFactory.get("step1")
				.<Article, Article>chunk(100)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
	@Bean
	public Job exportArticleJob(){
		return  jobBuilderFactory.get("exportArticleJob")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}
}
