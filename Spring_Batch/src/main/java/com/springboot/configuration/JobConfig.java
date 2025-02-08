package com.springboot.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.springboot.entity.Person;

@Configuration
public class JobConfig {

	@Bean
	public Job job(JobRepository jobRepository,Step step) {
		return new JobBuilder("importPerson", jobRepository)
				             .start(step)
				             .build();
	}
	
	public Step step(JobRepository jobRepository,PlatformTransactionManager transactionManager) {
		return new StepBuilder("csv-import-step",jobRepository)
				   .<Person,Person>chunk(10,transactionManager)
				   .reader(reader())
				   .processor(processor())
				   .writer(writer())
				   .build();
	}

	private ItemWriter<? super Person> writer() {
		// TODO Auto-generated method stub
		return null;
	}

	private ItemProcessor<? super Person, ? extends Person> processor() {
		// TODO Auto-generated method stub
		return null;
	}

	private ItemReader<? extends Person> reader() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
