package com.solsbench.common.log;


public class Logger {
	
	public static Logger getLogger(Class className) {
		return new Logger();
	}
	
	public void info(String message){
		System.out.println(message);
	}
	
	public void error(String message, Exception ex){
		System.out.println(message);
	}
}
