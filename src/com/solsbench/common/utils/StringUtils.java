package com.solsbench.common.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

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
	 * trim
	 * 
	 * @param text
	 * @return String
	 */
	public String[] trim(String[] text) {
		if(text != null) {
			for(int i=0; i<text.length; i++) {
				text[i] = trim(text[i]);
			}
		}
		return text;
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public String[] trimToNull(String[] text) {
		if(text != null) {
			for(int i=0; i<text.length; i++) {
				text[i] = trimToNull(text[i]);
			}
		}
		return text;
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public String[] trimToEmpty(String[] text) {
		if(text != null) {
			for(int i=0; i<text.length; i++) {
				text[i] = trimToEmpty(text[i]);
			}
		}
		return text;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public List toArrayList(String t[]) {
		List list = new ArrayList();
		for(String t1 : t) {
			list.add(t1);
		}
		return list;
	}
	
	/**
	 * trim
	 * 
	 * @param text
	 * @return String
	 */
	public List trim(List text) {
		List list = null;
		if(text != null) {
			String[] textArr = trim((String[])text.toArray(new String[text.size()]));
			list = toArrayList(textArr);
		}
		return list;
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public List trimToNull(List text) {
		List list = null;
		if(text != null) {
			String[] textArr = trimToNull((String[])text.toArray(new String[text.size()]));
			list = toArrayList(textArr);
		}
		return list;
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public List trimToEmpty(List text) {
		List list = null;
		if(text != null) {
			String[] textArr = trimToEmpty((String[])text.toArray(new String[text.size()]));
			list = toArrayList(textArr);
		}
		return list;
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
