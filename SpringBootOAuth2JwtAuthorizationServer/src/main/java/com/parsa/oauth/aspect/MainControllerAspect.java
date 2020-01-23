package com.parsa.oauth.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.parsa.oauth.model.Client;
import com.parsa.oauth.model.User;

@Aspect
@Component
public class MainControllerAspect {

	Logger logger = LoggerFactory.getLogger(MainControllerAspect.class);
	
	@Before(value = "execution(* com.parsa.oauth.controller.MainController.registerUser(..)) and args(user)")
	public void registerUser(User user) {
		logger.info("-----> creating user: "+ user.getUsername());
	}
	
	
	@Before(value = "execution(* com.parsa.oauth.controller.MainController.registerClient(..)) and args(client)")
	public void registerUser(Client client) {
		logger.info("-----> creating user: "+ client.getClientId());
	}
}
