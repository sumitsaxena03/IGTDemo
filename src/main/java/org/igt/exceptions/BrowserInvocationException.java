package org.igt.exceptions;

/**
 * Custom exception to capture exceptions generated while invoking any browser.
 * Mar 31, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see FrameworkException
 */
public class BrowserInvocationException extends FrameworkException {

	public BrowserInvocationException(String message) {
		super(message);
	}
	public BrowserInvocationException(String message,Throwable cause) {
		super(message,cause);
	}
}
