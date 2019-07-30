package com.emaratech.assignment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.emaratech.assignment.domain.model.PhoneBook;
import com.emaratech.assignment.exception.NumberNotFoundException;
import com.emaratech.assignment.repository.PhoneRegisteryRepository;
import com.emaratech.assignment.resources.PhoneBookListResource;
import com.emaratech.assignment.resources.assembler.PhoneBookListResourceAssembler;

@Service
public class PhoneBookServiceImpl extends BasicAbstractService<PhoneBook> implements PhoneBookService{
	public PhoneBookServiceImpl(JpaRepository<PhoneBook, Long> jpaRepository) {
		super(jpaRepository);
	}

	@Autowired
	public PhoneRegisteryRepository phoneRegisteryDao;

	@Autowired
	private PhoneBookListResourceAssembler phoneBookListResourceAssembler;


	@Override
	public PhoneBookListResource getPhoneNumbersList(int pageNumber,String phoneNumber) {
		PhoneBook phoneBooKEntity =new PhoneBook();
		if(phoneNumber!=null&&!phoneNumber.isEmpty())
			phoneBooKEntity.setPhoneNumber(phoneNumber);
		Page<PhoneBook> page =this.findAll(phoneBooKEntity,PageRequest.of(pageNumber, 14));
		return phoneBookListResourceAssembler.build(page);
	}

	@Override
	public PhoneBook findNumberById(Long id) {		
		return phoneRegisteryDao.findById(id).orElseThrow(() -> new NumberNotFoundException(id));
	}



}
