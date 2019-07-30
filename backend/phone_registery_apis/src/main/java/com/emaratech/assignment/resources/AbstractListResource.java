package com.emaratech.assignment.resources;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import org.springframework.hateoas.ResourceSupport;

@Getter
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class AbstractListResource extends ResourceSupport {
	private final int pageNumber;
	private final int pageSize;
	private final int totalPages;
	private final long totalElements;
}
