package com.spring.nemo.soap_service_demo_client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.spring.nemo.soap_service_demo_client.client.SoapClient;

@Configuration
public class SoapConfig {
//	@Value("${ENDPOINT_SERVICE_COURSE}")
	private String endpoint = "http://localhost:8082/ws";

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.spring.nemo.soap_service_demo_client.courses");
		return marshaller;
	}

	/*
	 * 
	 * This method for configure for web service client such as endpoint ,
	 * marshaller , unmarshaller
	 * 
	 */

	@Bean
	public SoapClient courseClinet(Jaxb2Marshaller marshaller) {

		SoapClient client = new SoapClient();
		client.setDefaultUri("http://localhost:8082/ws");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		client.setInterceptors(new ClientInterceptor[] { securityInterceptor() });
		return client;

	}

	@Bean
	public Wss4jSecurityInterceptor securityInterceptor() {
		Wss4jSecurityInterceptor wss4jSecurityInterceptor = new Wss4jSecurityInterceptor();
		wss4jSecurityInterceptor.setSecurementActions("UsernameToken");
		wss4jSecurityInterceptor.setSecurementPasswordType("PasswordText");
		wss4jSecurityInterceptor.setSecurementUsername("user");
		wss4jSecurityInterceptor.setSecurementPassword("password");
		return wss4jSecurityInterceptor;
	}

}
