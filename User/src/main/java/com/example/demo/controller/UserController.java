package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public List<Users> allUsers(){
		return userService.getAllUsers();
	}
	@GetMapping("/user/{id}")
	public Optional<Users> userById(@PathVariable ("id") int id) {
		return userService.getUserById(id);
	}
	@PutMapping("/user")
	public Users updatedUser(@RequestBody Users user) {
		return userService.updateUser(user);
	}
	@DeleteMapping("/users/{id}")
	public void deleteUSer(int id) {
		userService.deleteUser(id);
	}
}