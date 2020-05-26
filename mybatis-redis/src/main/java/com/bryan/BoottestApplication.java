package com.bryan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@MapperScan(basePackages = "com.bryan.mapper")
//扫描原生servlet,filter,listener注解,使其可用
@ServletComponentScan
@SpringBootApplication
/**
 * 部署war包，需要继承SpringBootServletInitializer
 */
public class BoottestApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BoottestApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BoottestApplication.class, args);
	}
}
