package com.cloud.consume_ribbon.serviceImpl;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.cloud.consume_ribbon.vo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ComputeService {

    @Autowired
    RestTemplate restTemplate;
    String url = "http://approve/addUserPost";
    
    
    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public Integer addService() {
    	ResponseEntity<Integer> resposEntity = restTemplate.getForEntity("http://approve/add?a={1}&b={2}", Integer.class,10,20);//Integer第二个参数是返回类型，10,20是占位符{1}{2}的参数
    	Integer body = resposEntity.getBody();
    	System.err.println("********************" + body);
        return body;
    }
    @HystrixCommand(fallbackMethod = "addUserError")
    public User addUser() {
    	ResponseEntity<User> resposEntity = restTemplate.getForEntity("http://approve/addUser?name1={1}",User.class,"张三");
    	User body = resposEntity.getBody();
    	System.err.println("********************" + body);
    	return new User("成功",88);
    }
    @HystrixCommand(fallbackMethod = "addUserMapError")
    public User addUserMap() {
    	Map<String,String> params = new HashMap<>();
    	params.put("name", "33");
    	ResponseEntity<User> resposEntity = restTemplate.getForEntity("http://approve/addUserMap?name={name}",User.class,params);//注意：占位符只能是map集合中的key，不能是map的对象 
    	User body = resposEntity.getBody();
    	System.err.println("********************" + body);
    	return new User("成功",88);
    }
    
    @HystrixCommand(fallbackMethod = "addUserMapListError")
    public User addUserObject() {
    	Map<String,List<User>> params = new HashMap<>();
    	List<User> users = new ArrayList<>();
    	users.add(new User("name1",20));
    	users.add(new User("name2",30));
    	params.put("name", users);
    	User result = restTemplate.getForObject("http://approve/addUserMapList2?name={name}", User.class,params);
    	
    	System.err.println("********************" + result);
    	return new User("成功",88);
    }
    public User addUserPost() {
    	User user = new User("post",89);
    	
    	ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://approve/addUserPost",user,User.class);//user第二个参数不仅包含body，还包含header，目前没有搞明白包含的header在哪里？？？？，第三个参数是返回类型
    	User u = responseEntity.getBody();
    	System.err.println("********************" + u);
    	return new User("成功",88);
    }
    public User addUserPostUri() {
    	User user = new User("post",89);
    	UriComponents uriComponents =  UriComponentsBuilder.fromUriString("http://approve/addUserPost").build().encode();
    	URI uri = uriComponents.toUri();//同一资源标识符（Uniform Resource Identifier）的引用,对rul中的参数进行绑定使用
    	ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://approve/addUserPost",user,User.class,uri);//user第二个参数不仅包含body，还包含header，目前没有搞明白包含的header在哪里？？？？
    	User u = responseEntity.getBody();
    	System.err.println("********************" + u);
    	return new User("成功",88);
    }
    public User addUserPUT() {
    	User user = new User("put",89);
    	Long id = 11L;
//    	restTemplate.put("http://approve/addUserPUT/{1}", user, id);//占位符行不通，待解决？？？？
    	restTemplate.put("http://approve/addUserPUT", user);//put没有返回值
    	return new User("成功",87);
    }
    public User addUserDelete() {
    	User user = new User("delete",99);
    	String name1 = "sd";
//    	UriComponents uriComponents =  UriComponentsBuilder.fromUriString("http://approve/addUserDelete?name1={name1}").build().expand(name1).encode();
//    	URI uri = uriComponents.toUri();
    	restTemplate.delete("http://approve/addUserDelete?name1=" + name1);
    	return new User("成功",99);
    }
    
    
    
    
    
    
    
    
    
    
    
    public Integer addServiceFallback() {
    	
        return 0;
    }
    public User addUserError() {
    	
    	return new User("网络不稳定",99);
    }
    public User addUserMapError() {
    	
    	return new User("添加userMap网络不稳定",100);
    }
    public User addUserMapListError() {
    	
    	return new User("添加addUserMapListError网络不稳定",200);
    }
}
