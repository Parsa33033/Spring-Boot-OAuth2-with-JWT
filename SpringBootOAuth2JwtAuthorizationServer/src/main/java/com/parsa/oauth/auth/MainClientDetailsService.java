package com.parsa.oauth.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import com.parsa.oauth.model.Client;
import com.parsa.oauth.repository.ClientRepository;

@Service
public class MainClientDetailsService implements ClientDetailsService{

	@Autowired
	ClientRepository clientRepo;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		// TODO Auto-generated method stub
		Client client = clientRepo.findClientByClientId(clientId);
		if (client == null)
			throw new ClientRegistrationException("client not registered!");
		
		return client;
	}

}
