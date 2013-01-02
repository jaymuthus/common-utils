package com.solsbench.common.utils;

public class StringUtils {

	public boolean isEmpty(String text) {
		return null == text || "".equals(text);
	}
	
	public String trim(String text) {
		return null == text ? text : text.trim();
	}
	
}
