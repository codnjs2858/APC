package com.cafe24.memory.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.cafe24.memory.mapper", sqlSessionFactoryRef = "mybatisSqlSessionFactory")
public class MybatisConfig {
	
	@Bean(name="mybatisSqlSessionFactory")
	public SqlSessionFactory MybatisSqlSessionFactory(DataSource dataSource, ApplicationContext context) throws Exception {
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:mapper/**/*.xml"));
		sqlSessionFactoryBean.setTypeAliasesPackage("com.cafe24.memory.domain");
		
		return sqlSessionFactoryBean.getObject();
	}
}
