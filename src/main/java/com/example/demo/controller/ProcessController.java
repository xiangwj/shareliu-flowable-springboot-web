package com.example.demo.controller;

import javax.annotation.Resource;

import org.flowable.engine.RepositoryService;
import org.flowable.engine.repository.Deployment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
public class ProcessController {
	@Resource
	RepositoryService repositoryService;
	@RequestMapping("/testdeploy")
	public Deployment deploy() {
		Deployment deploy =repositoryService.createDeployment()
		.addClasspathResource("bpmn/TestUpload.bpmn")
		.tenantId("XIANGWJ")
		.deploy();
		return deploy;
		
	}
}
