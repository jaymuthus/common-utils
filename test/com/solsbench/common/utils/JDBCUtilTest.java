package com.solsbench.common.utils;

import java.util.ArrayList;
import java.util.List;

public class JDBCUtilTest {
	public static void testNumbers() {
		List<Long> numbers = new ArrayList<Long>();
		String columnName = "columnName";
		boolean isContains = true;
		numbers.add(100L);
		String clause = JDBCUtil.getSQLWhereClausePartByValues(numbers, columnName, isContains);
		
		System.out.println(clause);
		
		numbers.add(200L);
		clause = JDBCUtil.getSQLWhereClausePartByValues(numbers, columnName, isContains);
		System.out.println(clause);
		
		isContains = false;
		numbers = new ArrayList<Long>();
		numbers.add(100L);
		clause = JDBCUtil.getSQLWhereClausePartByValues(numbers, columnName, isContains);
		
		System.out.println(clause);
		
		numbers.add(200L);
		clause = JDBCUtil.getSQLWhereClausePartByValues(numbers, columnName, isContains);
		System.out.println(clause);
	}
	
	public static void testStrings() {
		List<String> values = new ArrayList<String>();
		String columnName = "programId";
		boolean isContains = true;
		values.add("100");
		String clause = JDBCUtil.getSQLWhereClausePartByValues(values, columnName, isContains);
		
		System.out.println(clause);
		
		values.add("200");
		clause = JDBCUtil.getSQLWhereClausePartByValues(values, columnName, isContains);
		System.out.println(clause);
		
		isContains = false;
		values = new ArrayList<String>();
		values.add("100");
		clause = JDBCUtil.getSQLWhereClausePartByValues(values, columnName, isContains);
		
		System.out.println(clause);
		
		values.add("200");
		clause = JDBCUtil.getSQLWhereClausePartByValues(values, columnName, isContains);
		System.out.println(clause);
	}
	
	public static void main(String s[]) {
		testNumbers();
		testStrings();
	}
}
