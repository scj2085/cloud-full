package com.cloud.approve_zuul;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;

import com.cloud.approve_zuul.filter.DidiFilterProcessor;
import com.cloud.approve_zuul.filter.ErrorFilter;
import com.cloud.approve_zuul.config.FilterConfiguration;
import com.cloud.approve_zuul.filter.AccessFilter;
import com.cloud.approve_zuul.filter.ThrowExceptionFilter;
import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.FilterProcessor;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;

/**
 * Hello world!
 *
 */
@EnableConfigurationProperties({FilterConfiguration.class})//动态加载过虑器配置类
@EnableZuulProxy
@SpringCloudApplication//它整合了@SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class ZullApplication {
	
    public static void main( String[] args ){
    	new SpringApplicationBuilder(ZullApplication.class).web(true).run(args);
    	FilterProcessor.setProcessor(new DidiFilterProcessor());//因为扩展的DidiFilterProcessor过滤器处理类并还没有生效。最后，我们需要在应用主类中，通过调用FilterProcessor.setProcessor(new DidiFilterProcessor());方法来启用自定义的核心处理器以完成我们的优化目标
    }
    /**
     * 创建动态加载过滤器的实例
     * @param filterConfiguration
     * @return
     */
//    @Bean
//    public FilterLoader filterLloader(FilterConfiguration filterConfiguration){
//    	FilterLoader filterLoader = FilterLoader.getInstance();
//    	filterLoader.setCompiler(new GroovyCompiler());
//    	try {
//			FilterFileManager.setFilenameFilter(new GroovyFileFilter());
//			//API网关应用会每隔5秒，从API网关所在位置的filter/pre和filter/post目录下获取定义的Groovy定义的过滤器，并进行编译和动态加载，zuul.filter.interval:动态加载时间间隔，zuul.filter.roo:调整根目录的位置，这里写死了/pre和/post目录，可做进一步扩展
//			FilterFileManager.init(
//					filterConfiguration.getInterval(),
//					filterConfiguration.getRoot() + "/pre",
//					filterConfiguration.getRoot() + "/post");
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//    	return filterLoader;
//    }
    /**
     * 
     * @return
     */
    @Bean
    @RefreshScope//此注解来将zuul的配置内容动态化
    @ConfigurationProperties("zuul")//"zuul"是git仓库approve-zuul.yml中的属性key，API网关服务的规则已经提取到git仓库，文件名必须和spring:application:name: approve-zuul		的名称一样
    public ZuulProperties zuulProperties(){
    	return new ZuulProperties();
    }
	/**
	 * 自定义网关zuul过滤器，实例化该过滤器才能生效
	 * @return
	 */
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
    @Bean
    public ThrowExceptionFilter throwExceptionFilter(){
    	return new ThrowExceptionFilter();
    }
    @Bean
    public ErrorFilter errorFilter(){
    	return new ErrorFilter();
    }
    
}
