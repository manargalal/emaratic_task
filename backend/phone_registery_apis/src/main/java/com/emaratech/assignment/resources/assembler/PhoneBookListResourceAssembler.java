package com.emaratech.assignment.resources.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.emaratech.assignment.controller.PhoneRegisteryController;
import com.emaratech.assignment.domain.model.PhoneBook;
import com.emaratech.assignment.resources.PhoneBookListResource;
import com.emaratech.assignment.resources.PhoneBookResource;
import com.emaratech.assignment.util.PageLinks;
@Component
public class PhoneBookListResourceAssembler {
	 

	    @PageLinks(PhoneRegisteryController.class)
	    public PhoneBookListResource build(Page<PhoneBook> page) {
	        List<PhoneBookResource> numberList = page.getContent()
	                .stream()
	                .map(PhoneBookResource::new)
	                .collect(Collectors.toList());

	        return new PhoneBookListResource(numberList, page.getNumber(),
	                page.getSize(), page.getTotalPages(), page.getTotalElements());
	    }

}
