/**
 * 
 */
package org.igt.exceptions;


/**
 * To declare custom exception methods for property file related usage.<p> 
 * This will extend main custom exception handling class (@link FrameworkException).
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
@SuppressWarnings("serial")
public class PropertyFileExceptions extends FrameworkException {

	public PropertyFileExceptions(String message) {
		super(message);
	}
	public PropertyFileExceptions(String message,Throwable cause) {
		super(message,cause);
	}
}

