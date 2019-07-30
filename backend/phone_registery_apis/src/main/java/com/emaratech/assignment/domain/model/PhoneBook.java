package com.emaratech.assignment.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.emaratech.assignment.domain.auditor.BasicUpdatableAudit;
import com.fasterxml.jackson.annotation.JsonInclude;


@Data
@Entity
@Table(name="PHONE_BOOK")
@EqualsAndHashCode(callSuper = false,exclude="id")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NamedQuery(name="PhoneBook.findAll", query="SELECT p FROM PhoneBook p")
@AllArgsConstructor
@NoArgsConstructor
public class PhoneBook extends BasicUpdatableAudit implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, updatable=false,nullable=false)
	private Long id;

	@Column(name="PHONE_NUMBER",length=20,nullable=false,unique=true)
	private String phoneNumber;

}
