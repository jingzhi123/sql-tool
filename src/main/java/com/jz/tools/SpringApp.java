package com.jz.tools;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * 指定mybatis扫描com.jz.tools.*.mapper包下的Mapper
 */
@MapperScan(basePackages = "com.jz.tools.*.mapper")
@SpringBootApplication
public class SpringApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringApp.class, args);
	}
}
