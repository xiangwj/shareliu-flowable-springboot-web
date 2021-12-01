package com.example.demo.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
@Configuration
public class ShareLiuConfig {
	@Resource
	ShareLiuDataSourceConfig shareLiuDataSourceConfig;
	@Resource
	CommonDataSourceConfig commonDataSourceConfig;
	
	@Bean(name="dataSource")
	@Primary
	public DataSource shareLiuDataSource() {
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(shareLiuDataSourceConfig.getUrl());
		ds.setUsername(shareLiuDataSourceConfig.getUsername());
		ds.setPassword(shareLiuDataSourceConfig.getPassword());
		ds.setDriverClassName(shareLiuDataSourceConfig.getDriverClassName());
		
		ds.setInitialSize(commonDataSourceConfig.getInitialSize());
		ds.setMinIdle(commonDataSourceConfig.getMinIdle());
		ds.setMaxActive(commonDataSourceConfig.getMaxActive());
		ds.setTestOnBorrow(commonDataSourceConfig.isTestOnBorrow());
		ds.setTestOnReturn(commonDataSourceConfig.isTestOnReturn());
		ds.setMinEvictableIdleTimeMillis(commonDataSourceConfig.getMinEvictableIdleTimeMillis());
		return ds;
	}
	
}
