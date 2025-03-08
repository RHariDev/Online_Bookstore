package com.project.OnlineBookStore.servicesImpl; 

import com.project.OnlineBookStore.models.User;
import com.project.OnlineBookStore.repository.UserRepository;
import com.project.OnlineBookStore.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll(); 
	}
	
	@Override
	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User registerUser(User user) {
		user.setCreatedAt(LocalDateTime.now());
		return userRepository.save(user);
	}
	
	@Override
	public boolean deleteUser(int id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	} 
}
