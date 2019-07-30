package com.emaratech.assignment.config.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;

import com.emaratech.assignment.config.DbConfig;
import com.emaratech.assignment.domain.model.PhoneBook;


@Configuration
@EnableBatchProcessing
public class BatchConfig {
	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;

	@Value("classPath:input/inputData.csv")
	private Resource inputResource;

	@Autowired
	private DbConfig dbConfig;


	@Bean
	public Job readCSVFileJob() {
		return jobs
				.get("readCSVFileJob")
				.incrementer(new RunIdIncrementer())
				.start(step())
				.build();
	}

	@Bean
	public Step step() {
		return steps
				.get("step")
				.<PhoneBook, PhoneBook>chunk(5)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}



	@Bean
	public FlatFileItemReader<PhoneBook> reader() {
		FlatFileItemReader<PhoneBook> itemReader = new FlatFileItemReader<>();
		itemReader.setLineMapper(lineMapper());
		itemReader.setLinesToSkip(1);
		itemReader.setResource(inputResource);
		return itemReader;
	}

	@Bean
	public LineMapper<PhoneBook> lineMapper() {
		DefaultLineMapper<PhoneBook> lineMapper = new DefaultLineMapper<>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "id", "phoneNumber" });
		lineTokenizer.setIncludedFields(new int[] { 0, 1, 2 });
		BeanWrapperFieldSetMapper<PhoneBook> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(PhoneBook.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}

	@Bean
	public ItemProcessor<PhoneBook, PhoneBook> processor() {
		return new FilterPhoneBookItemProcessor();
	}


	@Bean
	public JdbcBatchItemWriter<PhoneBook> writer() {
		JdbcBatchItemWriter<PhoneBook> itemWriter = new JdbcBatchItemWriter<>();
		itemWriter.setDataSource(dbConfig.dataSource());
		itemWriter.setSql("INSERT INTO PHONE_BOOK (ID, PHONE_NUMBER,CREATED_AT,CREATED_BY,UPDATED_AT,UPDATED_BY)"
				+ " VALUES (:id, :phoneNumber,SYSDATE(),'admin',SYSDATE(),'admin')");
		itemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<PhoneBook>());
		return itemWriter;
	}

}
