package org.igt.requestbuilder;

import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.aeonbits.owner.ConfigFactory;
import org.igt.enums.PropertiesType;
import org.igt.utils.PropertyUtilOwnerLib;
import org.igt.utils.PropertyUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * Reusable to method to construct the request/response for Restassured call to the server.
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see PropertiesType
 * @see PropertyUtils
 */
public class RequestBuilder { 
	private static PropertyUtilOwnerLib config = ConfigFactory.create(PropertyUtilOwnerLib.class);
	
	private RequestBuilder() {};
	/**
	 * Reusable method to construct the request for GET calls.
	 * @author Mandeep Sheoran
	 * @see PropertiesType
	 * @see PropertyUtils
	 */
	public static RequestSpecification buildRequestForGetCalls() {
		RestAssured.useRelaxedHTTPSValidation();
		return given()
				.baseUri(config.APIURL())
				.log()
				.all(); 
	}

	/**
	 * Reusable to method to construct the request for POST calls.
	 * @author Mandeep Sheoran
	 * @see PropertiesType
	 * @see PropertyUtils
	 */
	public static RequestSpecification buildRequestForPostCalls() {		
		RestAssured.useRelaxedHTTPSValidation();
		Map<String, String> headers= new HashMap<String, String>();
	//	headers.put("X-k8s-microservice-call", "14309F2F-81F0-4399-A168-8248763A95E3");
	return given()
				.baseUri(config.APIURL())
				.contentType(ContentType.JSON).headers(headers)
				.log()
				.all();
	}
}
