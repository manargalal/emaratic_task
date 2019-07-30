
package com.emaratech.assignment.config.batch;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.emaratech.assignment.domain.model.PhoneBook;

public class FilterPhoneBookItemProcessor implements ItemProcessor<PhoneBook, PhoneBook> {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private Set<PhoneBook> phoneNumbers = new HashSet<PhoneBook>();

	@Override
	public PhoneBook process(PhoneBook phone) throws Exception {

		if(phoneNumbers.contains(phone)) {
			return null;
		}
		phoneNumbers.add(phone);
		log.info("Inserting PHONE : " + phone);

		return phone;
	}

}
