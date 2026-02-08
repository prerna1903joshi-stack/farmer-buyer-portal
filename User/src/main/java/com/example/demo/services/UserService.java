package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<Users> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public Users updateUser(Users user) {
		return userRepository.save(user);
	}
	
	public Users registerUser(Users user) {
		return userRepository.save(user);
	}

	public Users loginUser(String email, String password) {
		Optional<Users> user = userRepository.findByEmail(email);
		if(user.isPresent() && user.get().getPassword().equals(password)) {
			return user.get();
		}
		return null;
	}

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
}
