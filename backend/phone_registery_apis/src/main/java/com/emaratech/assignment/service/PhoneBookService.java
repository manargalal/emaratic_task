package com.emaratech.assignment.service;

import javax.persistence.Entity;

import com.emaratech.assignment.domain.model.PhoneBook;
import com.emaratech.assignment.resources.PhoneBookListResource;

public interface PhoneBookService {
	public PhoneBookListResource getPhoneNumbersList(int pageNumber,String phoneNumber);
	public PhoneBook findNumberById(Long id) ;
}
