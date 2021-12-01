package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource.shareniu")
@PropertySource(value="classpath:config/database/jdbc-shareniu-${spring.profiles.active}.properties"
,encoding = "UTF-8"
,ignoreResourceNotFound = false)
public class ShareLiuDataSourceConfig extends DataSourceConfig{
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
}
