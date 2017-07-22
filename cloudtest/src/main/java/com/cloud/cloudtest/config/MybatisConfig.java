package com.cloud.cloudtest.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(value = "com.cloud.*.dao")
public class MybatisConfig {
    @Bean  
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {  
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();  
        sqlSessionFactoryBean.setDataSource(dataSource);  
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/cloud/*/mapper/*.xml"));  
        return sqlSessionFactoryBean.getObject();  
    } 
}
