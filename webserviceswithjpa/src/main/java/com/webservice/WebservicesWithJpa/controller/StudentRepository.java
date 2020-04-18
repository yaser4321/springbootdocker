package com.webservice.WebservicesWithJpa.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.WebservicesWithJpa.model.Student;
@RestResource(exported = false)
public interface StudentRepository extends JpaRepository<Student, String> {

	List<Student> findByLastName(String lastName);
	@Query("from Student where lastName=?1")
	List<Student> findByLastNameSorted(String lastName);
}
