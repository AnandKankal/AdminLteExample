package com.javabykiran.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.javabykiran.logger.LogginAspect;
import com.javabykiran.logger.PQR;
import com.javabykiran.model.State;
import com.javabykiran.model.User;
import com.javabykiran.model.Users;



@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan("com.javabykiran")
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class HibernateConfiguration {

	@Autowired
	private ApplicationContext context;

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		System.out.println(1111111);
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		factoryBean.setAnnotatedClasses(Users.class);
		factoryBean.setAnnotatedClasses(User.class);
		factoryBean.setAnnotatedClasses(State.class);
		return factoryBean;
	}
	
	@Bean
	LogginAspect getloggingCode() {
		return new LogginAspect();
	}
	
	
}
