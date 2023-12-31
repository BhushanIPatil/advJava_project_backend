package com.cdac.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.cdac.entity.User;
import com.cdac.exception.UserServiceException;
import com.cdac.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public int register(User user) {
		
		Optional<User> userCheck = userRepository.findByEmail(user.getEmail());
		if (userCheck.isEmpty()) {
			
			User savedUser = userRepository.save(user);
			return savedUser.getId();
		} else {
			throw new UserServiceException("User already registered!");
		}
	}

	public User login(String email, String password) {

		Optional<User> userOptional = userRepository.findByEmail(email);

		User user = userOptional.get();
		
		if (userOptional == null) {
			throw new UserServiceException("User with this email does not exist");
		}

		if (!user.getPassword().equals(password)) {
			throw new UserServiceException("Invalid password");
		}

		return user;
	}
}
