package com.dreams.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/*
* 1. Spring Cloud中discovery service 有许多种实现（eureka、consul、zookeeper等等），
* 2. @EnableDiscoveryClient基于spring-cloud-commons,
*    @EnableEurekaClient基于spring-cloud-netflix
* 3. 如果选用的注册中心是eureka，那么就推荐@EnableEurekClient，
*    如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
* */
@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
