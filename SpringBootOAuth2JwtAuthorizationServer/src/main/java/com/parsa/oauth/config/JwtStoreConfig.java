package com.parsa.oauth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("jwt")
public class JwtStoreConfig {

	private Resource keyStore;
	private String keyStorePassword;
	private String keyPairAlias;
	private String KeyPairPassword;

	public Resource getKeyStore() {
		return keyStore;
	}

	public void setKeyStore(Resource keyStore) {
		this.keyStore = keyStore;
	}

	public String getKeyStorePassword() {
		return keyStorePassword;
	}

	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	public String getKeyPairAlias() {
		return keyPairAlias;
	}

	public void setKeyPairAlias(String keyPairAlias) {
		this.keyPairAlias = keyPairAlias;
	}

	public String getKeyPairPassword() {
		return KeyPairPassword;
	}

	public void setKeyPairPassword(String keyPairPassword) {
		KeyPairPassword = keyPairPassword;
	}

}
