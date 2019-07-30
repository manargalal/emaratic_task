package com.emaratech.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emaratech.assignment.domain.model.PhoneBook;

@Repository
public interface PhoneRegisteryRepository extends JpaRepository<PhoneBook, Long>{

}
