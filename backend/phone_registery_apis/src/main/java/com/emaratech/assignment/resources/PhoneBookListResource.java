package com.emaratech.assignment.resources;

import java.util.Collection;



import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter

public class PhoneBookListResource extends AbstractListResource{
	private final Collection<PhoneBookResource> numbers;
	
	public PhoneBookListResource(Collection<PhoneBookResource> numbers, int pageNumber, int pageSize, int totalPages,
			long totalElements){
		super(pageNumber, pageSize, totalPages, totalElements);
		this.numbers = numbers;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numbers == null) ? 0 : numbers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhoneBookListResource other = (PhoneBookListResource) obj;
		if (numbers == null) {
			if (other.numbers != null)
				return false;
		} else if (!numbers.equals(other.numbers))
			return false;
		return true;
	} 
	
}
