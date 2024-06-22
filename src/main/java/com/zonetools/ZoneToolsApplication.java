package com.zonetools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/springmvc-context.xml")
public class ZoneToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZoneToolsApplication.class, args);
	}

}
