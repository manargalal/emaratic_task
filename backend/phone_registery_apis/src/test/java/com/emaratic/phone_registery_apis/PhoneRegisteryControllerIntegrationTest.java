package com.emaratic.phone_registery_apis;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.emaratech.assignment.controller.PhoneRegisteryController;
import com.emaratech.assignment.domain.model.PhoneBook;
import com.emaratech.assignment.resources.PhoneBookListResource;
import com.emaratech.assignment.resources.PhoneBookResource;
import com.emaratech.assignment.service.PhoneBookService;
import com.emaratech.assignment.service.PhoneBookServiceImpl;

public class PhoneRegisteryControllerIntegrationTest {

	private MockMvc mockMvc;

	@InjectMocks
	private PhoneRegisteryController phoneRegisteryController;
	@Mock
	private  PhoneBookServiceImpl phoneBookService;
	private PhoneBookListResource phoneList  ;



	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(phoneRegisteryController).build();
		setupPhoneBook();
	}


	public void  setupPhoneBook(){
		PhoneBook numA = new PhoneBook();
		numA.setId((long) 1);
		numA.setPhoneNumber("86897989");
		PhoneBookResource numbersResource =new PhoneBookResource(numA);
		List<PhoneBookResource> numbersResourceList =new ArrayList<>();
		numbersResourceList.add(numbersResource);
		PhoneBookListResource phoneList  =new PhoneBookListResource(numbersResourceList, 0, 14, 1, 1);
		phoneList.add(linkTo(PhoneRegisteryController.class).withRel("numbers"));
	}

	@Test
	public void testRetreivePhoneNumbersList() throws Exception {
		this.mockMvc.perform(get("/api/v1/numbers?pageNumber=0"))
		.andExpect(status().isOk())
		.andDo(MockMvcResultHandlers.print())
		.andReturn();
	}





}
