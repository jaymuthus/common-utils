package com.solsbench.common.fwk.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

import com.sirahu.apptivo.common.logging.MessageLogger;

/**
 * This interface specifies the methods to be implemented by any file parsers.
 * The parsers are expected to parse the given file and return the java object. 
 * 
 * @author jaymuthus
 * 
 * @version 1.0
 */
public class CSVFileParser implements FileParser,java.io.Serializable {
	private static final MessageLogger logger = MessageLogger.getLogger(CSVFileParser.class);
	public static final char DEFAULT_SEPERATOR = ',';
	public static final char DEFAULT_TEXT_DELIMTER= '"';
	public static final int pageSize = 1000;


	protected List<String> fields = null;
	protected List<List<String>> dataLines = null;
	protected List<String> headerLine = null;
	
	protected char fieldSep;
	protected char textDelimiter;

	public CSVFileParser(){
		fieldSep = DEFAULT_SEPERATOR; 
		textDelimiter = DEFAULT_TEXT_DELIMTER;
	}
	
	/**
	 * Parse a given file and return a List of ArrayList.
	 * 
	 * @param <T>
	 * @param fileName
	 * @return T - Decided by the concrete class.
	 * @throws FileNotFoundException
	 */
	public List<String> parseHeaderLineOnly(String fileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String strLine = null;
		 List<String> headerLine = new ArrayList<String>();
		
		try {
			strLine = br.readLine();
			System.out.println(strLine);
			headerLine = parseLine(strLine);
			logger.info(headerLine.toString());
		} catch (IOException ex) {
			logger.error("CSVFileParser:parseFile Exception in the file parser", ex);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					logger.error("CSVFileParser:parseFile: unable to close the reader", ex);
				}
			}
		}
		return headerLine;
	}
	
	/**
	 * Parse a given file and return a List of ArrayList.
	 * 
	 * @param <T>
	 * @param fileName
	 * @return T - Decided by the concrete class.
	 * @throws FileNotFoundException
	 */
	public List<List<String>> parseFile(String fileName) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		String strLine = null;
		dataLines = new ArrayList<List<String>>();
		
		try {
			strLine = br.readLine();
			System.out.println(strLine);
			headerLine = parseLine(strLine);
			logger.info(headerLine.toString());
			
			while ((strLine = br.readLine()) != null) {
				fields = parseLine(strLine);
				logger.info(fields.toString());
				dataLines.add(fields);
			}
			logger.info(dataLines.toString());
		} catch (IOException ex) {
			logger.error("CSVFileParser:parseFile Exception in the file parser", ex);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					logger.error("CSVFileParser:parseFile: unable to close the reader", ex);
				}
			}
		}
		return dataLines;
	}
	public List<List<String>> parseFile(InputStream is){
		BufferedReader br = null;
		
		try
		{
			br = new BufferedReader(new InputStreamReader(is, "ISO-8859-1"));
		} catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		if(br == null)
		{
			br = new BufferedReader(new InputStreamReader(is));
		}
		
		String strLine = null;
		dataLines = new ArrayList<List<String>>();
		
		try {
			strLine = br.readLine();
			System.out.println(strLine);
			headerLine = parseLine(strLine);
			logger.info(headerLine.toString());
			
			while ((strLine = br.readLine()) != null) {
				fields = parseLine(strLine);
				logger.info(fields.toString());
				boolean isEmpty = true;
				for(String field : fields)
				{
					if(field != null && field.trim().length()>0)
					{
						isEmpty = false;
						break;
					}
				}
				if(!isEmpty)
				{
					dataLines.add(fields);
				}
			}
//			logger.info(dataLines.toString());
		} catch (IOException ex) {
			logger.error("CSVFileParser:parseFile Exception in the inputstream parser", ex);
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					logger.error("CSVFileParser:parseFile: unable to close the reader", ex);
				}
			}
		}
		return dataLines;
		
	}
	public List<String> getHeaderLine() {
		return headerLine;
	}

	public void setHeaderLine(List<String> headerLine) {
		this.headerLine = headerLine;
	}

	/**
	 * Parse a given line to a List of strings.
	 * 
	 * @param line
	 * @return List
	 */
	  public List<String> parseLine(String line) {
		  StringBuffer sb = new StringBuffer();
		  if(line != null) {
			  fields = new ArrayList<String>();
   		      int i = 0;

   		    if ("".equals(line)) {
   		      fields.add(line);
   		    } else {
   	   		    do {
   		            sb.setLength(0);
   		            if (i < line.length() && line.charAt(i) == textDelimiter) {
   		            	i = parseDelimitedToken(line, sb, ++i);  
   		            } else {
   		                i = parsePlainToken(line, sb, i);   		            	
   		            }
   		            fields.add(sb.toString().trim());
   			      i++;
   			    } while (i < line.length());
   		    }
		  }
	    return fields;
	  }

	  /**
	   * Parse delimitted token
	   * 
	   * @param s
	   * @param sb
	   * @param i
	   * @return int next token position.
	   */
	  protected int parseDelimitedToken(String s, StringBuffer sb, int i) {
	      int j;
	      int len= s.length();
	      for (j=i; j<len; j++) {
	            if (s.charAt(j) == '"' && j+1 < len) {
	                if (s.charAt(j+1) == '"') {
	                    j++; // skip escape char
	                } else if (s.charAt(j+1) == fieldSep) { //next delimeter
	                    j++; // skip end quotes
	                    break;
	                }
	            } else if (s.charAt(j) == '"' && j+1 == len) { // end quotes at end of line
	                break; //done
	      }
	      sb.append(s.charAt(j));  // regular character.
	    }
	    return j;
	  }

    /**
     * Parse unquoted string
     * 
     * @param s
     * @param sb
     * @param i
     * @return int Next token position
     */
	protected int parsePlainToken(String s, StringBuffer sb, int i) {
		int j;
		j = s.indexOf(fieldSep, i);
		if (j == -1) {
	        sb.append(s.substring(i)); //Read last token
	        return s.length();
	    } else {
	        sb.append(s.substring(i, j)); // Read next token
	        return j;
	    }
	}
	
	public static void main(String s[]) throws FileNotFoundException{
		CSVFileParser parser = new CSVFileParser();
		List<List<String>> lines = parser.parseFile("/home/mjayaraman/Documents/test.csv");
	}

}
