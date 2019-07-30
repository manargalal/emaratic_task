package com.emaratech.assignment.domain.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import com.emaratech.assignment.domain.auditor.BasicUpdatableAudit;
import com.fasterxml.jackson.annotation.JsonInclude;


@Data
@Entity
@Table(name="USERS")
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User extends BasicUpdatableAudit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, updatable=false,nullable=false)
	private Long id;
	
	@Column(name="USERNAME",unique=true,length=20,nullable=false)
	private String username;
	
	@Column(name="PASSWORD")
	private String password;

}
