package com.parsa.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parsa.oauth.model.Client;
import com.parsa.oauth.model.User;
import com.parsa.oauth.repository.ClientRepository;
import com.parsa.oauth.repository.UserRepository;

@RestController
public class MainController {

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ClientRepository clientRepo;
	
	@PostMapping(value = "/register-user", consumes = "application/json")
	public ResponseEntity<User> registerUser(@RequestBody User user) throws Exception{
		User userChecker = userRepo.findUserByUsername(user.getUsername());
		if (userChecker != null) {
			throw new Exception("user already exists!");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepo.saveAndFlush(user);
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(value = "/register-client", consumes = "application/json")
	public ResponseEntity<Client> registerClient(@RequestBody Client client) throws Exception{
		Client clientChecker = clientRepo.findClientByClientId(client.getClientId());
		if (clientChecker != null) {
			throw new Exception("client already exists!");
		}
		client.setClientSecret(passwordEncoder.encode(client.getClientSecret()));
		clientRepo.saveAndFlush(client);
		return ResponseEntity.ok(client);
	}
}
