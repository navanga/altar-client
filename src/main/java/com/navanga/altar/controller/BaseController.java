package com.navanga.altar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;

import com.netflix.discovery.EurekaClient;

public abstract class BaseController {
	
	@Autowired
	protected RestTemplateBuilder restTemplateBuilder;
}
