package tn.esprit.spring.Configuration;

import javax.annotation.Resource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tn.esprit.spring.entity.Article;

@Configuration
public class SpringBatchConfig {
	
	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory,
			org.springframework.batch.item.ItemReader<Article> itemReader,
			ItemProcessor<Article, Article> itemProcessor,
			ItemWriter<Article> itemWriter){
		Step step = stepBuilderFactory.get("ETL-file-load")
				.<Article, Article>chunk(100)
				.reader(itemReader)
				.processor(itemProcessor)
				.writer(itemWriter)
				.build();
		return jobBuilderFactory.get("ETL-Load")
		.incrementer(new RunIdIncrementer())
		.start(step )
		.build();
	}
	
	@Bean
	public FlatFileItemReader<Article> fileItemReader(@Value("${input}") org.springframework.core.io.Resource resource){
		FlatFileItemReader<Article> flatFileItemReader = new FlatFileItemReader<>();
		flatFileItemReader.setResource((org.springframework.core.io.Resource) resource);
		flatFileItemReader.setName("CSV-Reader");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
		
		
	}

	private LineMapper<Article> lineMapper() {
		DefaultLineMapper<Article> defaultLineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[]{"id_article","nom","qte_stock"});
		BeanWrapperFieldSetMapper<Article> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(Article.class);
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
}
