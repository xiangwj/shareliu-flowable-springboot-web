package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.flowable.ui.common.model.UserRepresentation;
import org.flowable.ui.common.security.DefaultPrivileges;
import org.flowable.ui.common.security.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class FormUserController {
	@RequestMapping("/rest/account")
	public UserRepresentation getAccount() {
		User user = new UserEntityImpl();
		user.setId("admin");
		SecurityUtils.assumeUser(user);
		
		UserRepresentation userRepresentation = new UserRepresentation();
		userRepresentation.setId("admin");
		userRepresentation.setEmail("wenjunxp@sina.com");
		userRepresentation.setFullName("Administrator");
		userRepresentation.setLastName("系统管理员");
		userRepresentation.setFirstName("");
		
		List<String> privileges = new ArrayList<>();
		privileges.add(DefaultPrivileges.ACCESS_MODELER);
		privileges.add(DefaultPrivileges.ACCESS_IDM);
		privileges.add(DefaultPrivileges.ACCESS_ADMIN);
		privileges.add(DefaultPrivileges.ACCESS_TASK);
		privileges.add(DefaultPrivileges.ACCESS_REST_API);
		
		userRepresentation.setPrivileges(privileges);
		return userRepresentation;
	}
}
