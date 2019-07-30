package com.emaratech.assignment.resources;
import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.emaratech.assignment.controller.PhoneRegisteryController;
import com.emaratech.assignment.domain.model.PhoneBook;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@EqualsAndHashCode(callSuper = false)
public class PhoneBookResource extends ResourceSupport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	 private final PhoneBook phoneBook;

	  public PhoneBookResource(final PhoneBook phoneBook) {
	    this.phoneBook = phoneBook;
	    final long id = phoneBook.getId();
	    add(linkTo(PhoneRegisteryController.class).withRel("numbers"));
	    add(linkTo(methodOn(PhoneRegisteryController.class).getPhoneNumber(id)).withSelfRel());
	  }

}
