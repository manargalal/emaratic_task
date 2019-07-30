
package com.emaratech.assignment.controller;


import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.emaratech.assignment.domain.model.PhoneBook;
import com.emaratech.assignment.resources.PhoneBookListResource;
import com.emaratech.assignment.resources.PhoneBookResource;
import com.emaratech.assignment.service.PhoneBookService;

@RestController
@RequestMapping("api/v1")
@Api(value = "PhoneRegisteryController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PhoneRegisteryController {
	@Autowired
	public PhoneBookService phoneBookService;

	@RequestMapping(value = "/numbers", method = RequestMethod.GET)
	public ResponseEntity<PhoneBookListResource> getPhoneNumbersList(@RequestParam int pageNumber, @RequestParam(value = "phoneNumber", required=false) String phoneNumber){
		PhoneBookListResource phoneList =phoneBookService.getPhoneNumbersList(pageNumber,phoneNumber);
		return ResponseEntity.ok(phoneList);
	}

	
	@RequestMapping(value = "/number", method = RequestMethod.GET)
	public ResponseEntity<PhoneBookResource> getPhoneNumber(@RequestParam long id){
		PhoneBook number = phoneBookService.findNumberById(id);
			return ResponseEntity.ok(new PhoneBookResource(number));
	
		
	}
}
