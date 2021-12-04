package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shareniu/rest")
public class ShareniuAccountController {
	@RequestMapping("/account")
	public String getAccount() {
		return "{\"id\":\"admin\",\"firstName\":\"Test\",\"lastName\":\"Administrator\",\"email\":\"admin@flowable.org\",\"fullName\":\"Test Administrator\",\"groups\":[],\"privileges\":[\"access-idm\",\"access-rest-api\",\"access-task\",\"access-modeler\",\"access-admin\"]}";
	}
}
