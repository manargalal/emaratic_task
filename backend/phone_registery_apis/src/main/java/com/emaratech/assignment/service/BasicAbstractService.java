package com.emaratech.assignment.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public abstract class BasicAbstractService<Entity> {

	@Autowired
	protected ModelMapper modelMapper;

	private JpaRepository<Entity, Long> jpaRepository;

	public BasicAbstractService(JpaRepository<Entity, Long> jpaRepository) {
		this.jpaRepository = jpaRepository;
	}



	public List<Entity> findAll()  {
		return jpaRepository.findAll();
	}

	public List<Entity> findAll(Entity example)  {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
		return jpaRepository.findAll(Example.of(example, matcher));

	}

	public Page<Entity> findAll(Entity example, Pageable pageable)  {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
		return jpaRepository.findAll(Example.of(example, matcher), pageable);

	}

	public List<Entity> findAll(Entity example, Sort sort) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
		return jpaRepository.findAll(Example.of(example, matcher), sort);

	}

	public Page<Entity> findAll(Pageable pageable)  {
		return jpaRepository.findAll(pageable);

	}

	public List<Entity> findAll(Sort sort)   {
		return jpaRepository.findAll(sort);
	}

	public List<Entity> findAllById(Iterable<Long> ids)  {
		return jpaRepository.findAllById(ids);
	}

	public Entity findById(Long id)  {
		return jpaRepository.findById(id).orElse(null);
	}

	public Entity findOne(Entity example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
		return jpaRepository.findOne(Example.of(example, matcher)).orElse(null);

	}

	public void flush() {
		jpaRepository.flush();
	}

	public Entity getOne(Long id)   {
		return jpaRepository.getOne(id);
	}

	public Entity save(Entity entity)  {
		return jpaRepository.save(entity);
	}

	public List<Entity> saveAll(Iterable<Entity> entities)  {
		return jpaRepository.saveAll(entities);
	}

	public Entity saveAndFlush(Entity entity)   {
		return jpaRepository.saveAndFlush(entity);
	}
}
