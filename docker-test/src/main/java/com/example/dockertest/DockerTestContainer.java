package com.example.dockertest;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class DockerTestContainer {
	@GetMapping(path="/{userID}")
	public String getUser(@PathVariable String userID) {
		return "hello "+userID;
	}
}
