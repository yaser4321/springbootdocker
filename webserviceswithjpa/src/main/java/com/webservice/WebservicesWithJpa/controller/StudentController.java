package com.webservice.WebservicesWithJpa.controller;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import javassist.tools.web.BadHttpRequest;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
  





import com.webservice.WebservicesWithJpa.model.Student;

@RestController
@RequestMapping("/users")
public class StudentController {

	@Autowired
	private StudentRepository repo;
	
	@GetMapping(produces={MediaType.APPLICATION_XML_VALUE})
	public Iterable<Student>findAll(){
		return repo.findAll();
	}
	
	@GetMapping( path="/{userId}",produces =  org.springframework.http.MediaType.APPLICATION_XML_VALUE)
	public Optional<Student> find(@PathVariable String userId){
		
		return repo.findById(userId);
	}
	@GetMapping( path="/name/{lastName}",produces =  org.springframework.http.MediaType.APPLICATION_XML_VALUE)
	public List<Student> findName(@PathVariable String lastName){
		System.out.println(repo.findByLastNameSorted(lastName));
		return repo.findByLastName(lastName);
	}
	 @PostMapping(consumes = "application/xml",produces={MediaType.APPLICATION_XML_VALUE})
	    public Student create(@RequestBody Student student, final HttpServletResponse response) {
		// response.setStatus(HttpServletResponse.SC_RESET_CONTENT);  
		 return repo.save(student);
	    }

	   @DeleteMapping(path = "/{userId}")
	    public void delete(@PathVariable("userId") String userId) {
	       repo.deleteById(userId);
	    }

	    @PutMapping(path = "/{userId}")
	    public Student update(@PathVariable("userId") String userId, @RequestBody Student student) throws BadHttpRequest {
	        if (repo.existsById(userId)) {
	            student.setUserId(userId);
	            return repo.save(student);
	        } else {
	            throw new BadHttpRequest();
	        }
	    }
}
