package com.solsbench.common.utils;

import java.io.File;
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
	 * isNull
	 * 
	 * @param text
	 * @return boolean
	 */
	public static boolean isNull(String text) {
		return null == text;
	}
	
	/**
	 * isNotNull
	 * 
	 * @param text
	 * @return boolean
	 */
	public static boolean isNotNull(String text) {
		return !isNull(text);
	}
	
	/**
	 * isEmpty
	 * 
	 * @param text
	 * @return boolean
	 */
	public static boolean isEmpty(String text) {
		return text != null && "".equals(text);
	}
	
	/**
	 * isNotEmpty
	 * 
	 * @param text
	 * @return boolean
	 */
	public static boolean isNotEmpty(String text) {
		return !isEmpty(text);
	}

	/**
	 * isNullOrEmpty
	 * 
	 * @param text
	 * @return boolean
	 */
	public static boolean isNullOrEmpty(String text) {
		return text == null || "".equals(text);
	}
	
	/**
	 * isNotNullOrEmpty
	 * 
	 * @param text
	 * @return boolean
	 */
	public static boolean isNotNullOrEmpty(String text) {
		return !isNullOrEmpty(text);
	}
	
	/**
	 * trim
	 * 
	 * @param text
	 * @return String
	 */
	public static String trim(String text) {
		return null == text ? text : text.trim();
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public static String trimToNull(String text) {
		return null == text || "".equals(text) ? null : text.trim();
	}
	
	/**
	 * String
	 * 
	 * @param text
	 * @return String
	 */
	public static String trimToEmpty(String text) {
		return null == text || "".equals(text) ? "" : text.trim();
	}
	
	
	/**
	 * trim
	 * 
	 * @param text
	 * @return String
	 */
	public static String[] trim(String[] text) {
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
	public static String[] trimToNull(String[] text) {
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
	public static String[] trimToEmpty(String[] text) {
		if(text != null) {
			for(int i=0; i<text.length; i++) {
				text[i] = trimToEmpty(text[i]);
			}
		}
		return text;
	}
	
	/**
	 * 
	 * @param t[]
	 * @return List
	 */
	public static List<String> toArrayList(String t[]) {
		List<String> list = new ArrayList<String>();
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
	public static List<String> trim(List<String> text) {
		List<String> list = null;
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
	public static List<String> trimToNull(List<String> text) {
		List<String> list = null;
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
	public static List<String> trimToEmpty(List<String> text) {
		List<String> list = null;
		if(text != null) {
			String[] textArr = trimToEmpty((String[])text.toArray(new String[text.size()]));
			list = toArrayList(textArr);
		}
		return list;
	}
	
	/**
	 * 
	 * @param e
	 * @return String
	 */
    public static String toString(Exception e) {  
        StringWriter s = new StringWriter();  
        e.printStackTrace(new PrintWriter(s));  
        return s.toString();   
    }  
    
    /**
     * mergeStringArrays
     * 
     * @param array1
     * @param array2
     * @return String
     */
    public static String[] mergeStringArrays(String array1[], String array2[]) {  
    	int length = 0;
    	if(array1 != null) {
    		length += array1.length;
    	}
    	
    	if(array2 != null) {
    		length += array2.length;
    	}
    	
    	String[] array = new String[length];
    	if(array1 != null) {
    		System.arraycopy(array1, 0, array, 0,  array1.length);
    	}
    	
    	if(array1 != null && array2 != null) {
    		System.arraycopy(array2, 0, array, array1.length,  array2.length);
    	} else {
    		System.arraycopy(array2, 0, array, 0,  array2.length);
    	}
    	return array;
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
    
    /**
     * extractFileName
     * 
     * @param absoluteFileName
     * @return String
     */
    public static String extractFileName(String absoluteFileName) {  
    	if (!isNullOrEmpty(absoluteFileName)) {  
		  	absoluteFileName = absoluteFileName.substring(absoluteFileName.lastIndexOf(File.separatorChar) + 1, absoluteFileName.lastIndexOf("."));  
		  
		}  
		return absoluteFileName;  
	}  
}
