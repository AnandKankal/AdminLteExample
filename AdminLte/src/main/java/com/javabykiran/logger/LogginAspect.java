package com.javabykiran.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;

@Aspect
public class LogginAspect {
	
	Logger logger1 = Logger.getLogger(getClass().getName());

	@Before("execution(* com.javabykiran.controller.LoginController.checkLogin(..))")
	public void logControllermetodsBef(JoinPoint joinpoint) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		System.out.println("Started calling  checkLogin of LoginController  at "+date);
		//System.out.println("entering into method  >>>" + joinpoint.getSignature().getName());
	}
	
	@Before("execution(* com.javabykiran.service.LoginService.checkLogin(..))")
	public void logServicemetodsBef(JoinPoint joinpoint) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		System.out.println("Started calling checkLogin of LoginService  at "+date);
		//System.out.println("entering into method  >>>" + joinpoint.getSignature().getName());
	}
	
	@Before("execution(* com.javabykiran.dao.LoginDao.checkUser(..))")
	public void logDaometodsBef(JoinPoint joinpoint) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		System.out.println("Started calling checkLogin of LoginDao  at "+date);
		//System.out.println("entering into method  >>>" + joinpoint.getSignature().getName());
	}
	
	
	@After("execution(* com.javabykiran.controller.LoginController.checkLogin(..))")
	public void logControllermetodsAft(JoinPoint joinpoint) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		System.out.println("Exiting calling  checkLogin of LoginController  at "+date);
		//System.out.println("entering into method  >>>" + joinpoint.getSignature().getName());
	}
	
	@After("execution(* com.javabykiran.service.LoginService.checkLogin(..))")
	public void logServicemetodsAft(JoinPoint joinpoint) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		System.out.println("Exiting calling checkLogin of LoginService  at "+date);
		//System.out.println("entering into method  >>>" + joinpoint.getSignature().getName());
	}
	
	@After("execution(* com.javabykiran.dao.LoginDao.checkUser(..))")
	public void logDaometodsAft(JoinPoint joinpoint) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm a");
		Date date = new Date();
		//System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43

		System.out.println("Exiting calling checkLogin of LoginDao  at "+date);
		//System.out.println("entering into method  >>>" + joinpoint.getSignature().getName());
	}
	
	
	@Pointcut(value="execution(* com.javabykiran.controller.*.*(..))")
	private void getcontroller()   
	{   
	} 

	@Pointcut(value="execution(* com.javabykiran.service.*.*(..))")
	private void getservice()   
	{ 
		
	} 
	

	@Pointcut(value="execution(* com.javabykiran.dao.*.*(..))")
	private void getdao()   
	{ 
		
	}
	
	@Around("getcontroller()||getservice()||getdao()")
public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable   {
		
		String method=jp.getSignature().getName();
		
		long start=System.currentTimeMillis();
		
		Date date=new Date(start);
		
		//System.out.println("start calling "+method+"at"+date+".");
		logger1.info("start calling "+method+"at"+date+".");
		
		Object rs=null;
		
	  
	try   
	{  
	rs=jp.proceed();  
	}   
	catch (Exception e) {
		e.printStackTrace();
	}
        return rs;  
	}

	
	
	
}
