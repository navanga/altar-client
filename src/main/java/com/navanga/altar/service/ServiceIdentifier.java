package com.navanga.altar.service;

public enum ServiceIdentifier {

	BANK_SERVICE("bank-service");

	private String serviceName;

	ServiceIdentifier(String serviceName) {
		this.serviceName = serviceName;
	}
	
	public String getServiceName() {
		return this.serviceName;
	}

}
