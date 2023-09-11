package org.igt.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;
import lombok.SneakyThrows;

/**
 * Class to provide untility methods to handle external file integration.
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see Files
 */
public final class ApiUtils {
	
	private ApiUtils() {};	
	/**
	 * Method to provide implementation of reading content from external files.
	 * @author Mandeep Sheoran
	 */
	@SneakyThrows
	public static String readFromExternalFile(String filepath) {
		try {
			return new String(Files.readAllBytes(Paths.get(filepath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return null;
	}
	
	/**
	 * Method to provide implementation for storing response in external files.
	 * @author Mandeep Sheoran
	 */
	@SneakyThrows
	public static void saveReturnedPostResponse(String filepath, Response response) {
		try {
			Files.write(Paths.get(filepath), response.asByteArray());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
