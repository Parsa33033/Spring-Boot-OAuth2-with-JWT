package com.parsa.oauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parsa.oauth.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
	Client findClientByClientId(String clientId);
}
