package com.project.OnlineBookStore.services; 

import com.project.OnlineBookStore.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
	List<User> getAllUsers();
	Optional<User> getUserById(int id);
	Optional<User> getUserByEmail(String Email);
	User registerUser(User user);
	boolean deleteUser(int id); 
}
