package com.navanga.altar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@Service
public class ServiceDiscovery {
	
	@Autowired
	protected EurekaClient eurekaClient;

	public InstanceInfo getServiceInstance(ServiceIdentifier serviceIdentifier) {
		return eurekaClient.getNextServerFromEureka(serviceIdentifier.getServiceName(), false);
	}
	
}
