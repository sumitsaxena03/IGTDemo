package org.igt.exceptions;

/**
 * Class to declare custom exception for invalid file path.<p>
 * This will entend main custom exception class (@link FrameworkException)
 * Mar 31, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
@SuppressWarnings("serial")
public class InvalidExcelFilePathException extends FrameworkException {  
	
	public InvalidExcelFilePathException(String message) {
		super(message);
	}
	public InvalidExcelFilePathException(String message,Throwable cause) {
		super(message,cause);
	}
}
