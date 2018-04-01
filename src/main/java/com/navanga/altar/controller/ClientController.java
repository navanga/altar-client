package com.navanga.altar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.navanga.altar.service.ServiceDiscovery;
import com.navanga.altar.service.ServiceIdentifier;
import com.netflix.appinfo.InstanceInfo;

@RestController
public class ClientController extends BaseController {

	@Autowired
	private ServiceDiscovery serviceDiscovery;
	
	@RequestMapping("/")
	public String callService() {
		
		RestTemplate restTemplate = restTemplateBuilder.build();
		
		InstanceInfo instanceInfo = serviceDiscovery.getServiceInstance(ServiceIdentifier.BANK_SERVICE);
		
		String baseUrl = instanceInfo.getHomePageUrl();
		
		String bankeRateURL = baseUrl + "bank/rate";
		
		ResponseEntity<String> response = restTemplate.exchange(bankeRateURL, HttpMethod.GET, null, String.class);
		
		return response.getBody();
	}
	
}
