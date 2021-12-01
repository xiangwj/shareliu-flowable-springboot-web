package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.CommonDataSourceConfig;
import com.example.demo.config.ShareLiuDataSourceConfig;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	ShareLiuDataSourceConfig shareLiuDataSourceConfig;

	@Resource
	CommonDataSourceConfig commonDataSourceConfig;
	@RequestMapping(value="/getUser")
	public String getUser() {
		System.out.println(shareLiuDataSourceConfig);
		return "分享牛1";
	}
}
