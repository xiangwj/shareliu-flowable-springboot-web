package com.example.demo.config;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
@Configuration
public class ShareLiuConfig {
	@Resource
	ShareLiuDataSourceConfig shareLiuDataSourceConfig;
	@Resource
	CommonDataSourceConfig commonDataSourceConfig;
	
	@Bean(name="shareLiuDataSource")
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
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager(@Qualifier("shareLiuDataSource")DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
