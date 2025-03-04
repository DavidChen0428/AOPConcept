package com.project.david.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.david.entity.User;
import com.project.david.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> listAllUsers(){
		return userRepository.findAll();
	}
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> getUser(Integer id){
		return userRepository.findById(id);
	}
	
	public User updateUser(Integer id,User updateUser) {
		return userRepository.findById(id).map(user -> {user.setName(updateUser.getName());
											   		  	user.setEmail(updateUser.getEmail());
											   		  	return userRepository.save(user);
											   		  	}).orElse(null);
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
}
