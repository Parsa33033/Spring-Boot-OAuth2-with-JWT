# Spring-Boot-OAuth2-with-JWT
Spring boot oauth2 authorization server and resource server using jwt access token

##Authorization Server
1) go to `SpringBootOAuth2JwtAuthorizationServer\src\main\resources` and fire up docker compose file as below:
```
... SpringBootOAuth2JwtAuthorizationServer\src\main\resources> docker-compose up
```
or you can just install MySQL database on your operating system manually. Note that you can change database name, username and password in docker-compose.yml file.

2) create a user by ```http://localhost:8081/register-user``` link by creating a post request with application/json content type.
```
{
	"username":"parsa",
	"password":"123",
	"enabled":true,
	"email": "parsa_h_m@outlook.com",
	"roles":[
		{
			"type":"USER"
		}	
	]
	
}
```
3) create a clinet application by ```http://localhost:8081/register-client``` link by creating a post request with application/json content type.
```
{
    "clientId": "clientId",
    "resourceIds": [
        "first_resource"
    ],
    "clientSecret": "{bcrypt}$2a$10$9CWZyuJwLRF0jVqnjNpzyejSGSUeokE/N2OOK5aY8Yj0fY8.O4A86",
    "scoped": true,
    "scope": [
        "read",
        "write"
    ],
    "authorizedGrantTypes": [
        "password",
        "client_credentials"
    ],
    "registeredRedirectUri": [
        "http://localhost:8080/"
    ],
    "authorities": [
        {
            "authority": "ROLE_CLIENT"
        }
    ],
    "accessTokenValiditySeconds": 86400,
    "refreshTokenValiditySeconds": -1,
    "additionalInformation": null,
    "secretRequired": true
}
```

## Resource Server
1) check authenticity by using ```http://localhost:8080/``` link.
