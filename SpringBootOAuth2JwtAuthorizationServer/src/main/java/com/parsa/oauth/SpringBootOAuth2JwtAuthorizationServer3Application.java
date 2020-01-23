package com.parsa.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringBootOAuth2JwtAuthorizationServer3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOAuth2JwtAuthorizationServer3Application.class, args);
	}

}
