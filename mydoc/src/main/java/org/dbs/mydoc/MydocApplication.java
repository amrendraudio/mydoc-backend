package org.dbs.mydoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.dbs.mydoc.controller")
public class MydocApplication {

	public static void main(String[] args) {
		SpringApplication.run(MydocApplication.class, args);
	}

}