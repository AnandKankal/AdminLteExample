package com.javabykiran.logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabykiran.config.WebConfiguration;

public class TestWithSpring {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(WebConfiguration.class);
		PQR pqr = context.getBean(PQR.class);
		pqr.m1();
		pqr.m2();
		pqr.m3();
	}
}
