package com.solsbench.common.utils;

import java.util.List;

public class JDBCUtil {

	
	/**
	 * Get Where Clause
	 * 
	 * @param values
	 * @param columnName
	 * @param isContains
	 * @return String
	 */
	public static <T> String getSQLWhereClausePartByValues(List<T> values, String columnName, boolean isContains) {
		String sqlString = "";
		String expression = ""; 
		
		if(isContains) {
			expression = " " + columnName + " = ";
		} else {
			expression = " " + columnName + " != ";
		}
		

		if (values.size() == 1) {
			sqlString += " and" + expression + ((values.get(0) instanceof String) ? "'" + values.get(0) + "'" : values.get(0));
		} else {
			sqlString += " and (";

			boolean appendOrAnd = false;

			for (T value : values) {
				if (appendOrAnd) {
					sqlString += isContains ? " or " : " and ";
				} else {
					appendOrAnd = true;
				}
				sqlString += expression + ((value instanceof String) ? "'" + value + "'" : value);
			}

			sqlString += ")";
		}
		return sqlString;
	}

}
