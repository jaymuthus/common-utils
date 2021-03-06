package com.solsbench.common.utils;

import java.lang.reflect.Method;
import java.util.List;

import com.solsbench.common.log.Logger;

/**
 * 
 * @author jaymuthus
 *
 */
public class ReflectionUtil {
	private static final Logger logger = Logger.getLogger(ReflectionUtil.class);
	
	/**
	 * 
	 * @param <T>
	 * @param className
	 * @return
	 */
	public static <T> Class<T> getClass(String className) {
		Class<T> clazz = null;
		try {
			Class.forName(className);
		} catch (Exception ex) {
			logger.error("Class not found", ex);
		}
		return clazz;
	}
	
	/**
	 * 
	 * @param methodName
	 * @param params
	 * @return
	 */
	public static Method getMethod(String methodName, List<?> params){
		
		
		return null;
	}
}
