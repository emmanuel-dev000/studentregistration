package com.pangan.studentregistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentRegistrationApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(StudentRegistrationApplication.class, args);
		for (String beanName : ctx.getBeanDefinitionNames()) {
			System.out.println(beanName);
		}
	}

}
