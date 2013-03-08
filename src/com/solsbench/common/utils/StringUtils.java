package com.solsbench.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * StringUtils
 * 
 * @author mjayaraman
 *
 */
public class StringUtils {

	/**
	 * isEmpty
	 * 
	 * @param text
	 * @return boolean
	 */
	public boolean isEmpty(String text) {
		return null == text || "".equals(text);
	}
	
	/**
	 * isNotEmpty
	 * 
	 * @param text
	 * @return boolean
	 */
	public boolean isNotEmpty(String text) {
		return !isEmpty(text);
	}
	
	/**
	 * trim
	 * 
	 * @param text
	 * @return String
	 */
	public String trim(String text) {
		return null == text ? text : text.trim();
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public String trimToNull(String text) {
		return null == text || "".equals(text) ? null : text.trim();
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public String trimToEmpty(String text) {
		return null == text || "".equals(text) ? "" : text.trim();
	}
	
	/**
	 * 
	 * @param e
	 * @return
	 */
    public static String toString(Exception e) {  
        
        StringWriter s = new StringWriter();  
        e.printStackTrace(new PrintWriter(s));  
        return s.toString();   
    }  
    
    /**
     * toString
     * 
     * @param e
     * @return String
     */
    public static String toString(Object object) {  
        return object.toString();   
    } 
    
}
