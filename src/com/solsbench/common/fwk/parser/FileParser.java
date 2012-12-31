package com.solsbench.common.fwk.parser;

import java.io.FileNotFoundException;


/**
 * This interface specifies the methods to be implemented by any file parsers.
 * The parsers are expected to parse the given file and return the java object. 
 * 
 * @author jaymuthus
 * 
 * @version 1.0
 */
public interface FileParser {
	
	/**
	 * Parse a given file and return an object.
	 * 
	 * @param <T>
	 * @param fileName
	 * @return T - Decided by the concrete class.
	 * @throws FileNotFoundException
	 */
	public <T> T parseFile(String fileName) throws FileNotFoundException;

}
