package com.emaratic.phone_registery_apis;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.*;

import com.emaratech.assignment.domain.model.PhoneBook;
import com.emaratech.assignment.repository.PhoneRegisteryRepository;
import com.emaratech.assignment.service.PhoneBookServiceImpl;

public class TestPhoneBooKService {
	@InjectMocks
	private PhoneBookServiceImpl phoneBookService;
	@Mock
	public PhoneRegisteryRepository phoneRegisteryDao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetPhoneNumbersList(){
		

		List<PhoneBook> numbersList = new ArrayList<>();
		numbersList.add(new PhoneBook((long) 1,"97105433323"));
		numbersList.add(new PhoneBook((long)2,"97105433377"));
		when(phoneRegisteryDao.findAll(any())).thenReturn(numbersList);
		Page<PhoneBook> pagedPhoneNumbers = new PageImpl(numbersList);
		Mockito.when(this.phoneBookService.findAll(isA(Pageable.class))).thenReturn(pagedPhoneNumbers);
	}

}
