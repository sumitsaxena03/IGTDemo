package org.igt.apitests;

import static org.igt.enums.LogType.CONSOLEANDEXTENTINFO;
import static org.igt.reports.FrameworkLogger.log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.constants.FrameworkConstants;
import org.igt.enums.LogType;
import org.igt.reports.ExtentLogger;
import org.igt.requestbuilder.RequestBuilder;
import org.igt.utils.ApiUtils;
import org.igt.utils.DateFormatUtils;
import org.igt.utils.RandomDataUtils;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostTest {

	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentASIADateTimeFormat() + "]");
	}

	@Test(description = "Create a new login user")
	@FrameworkAnnotations(author = "Mandeep", category = "SMOKE", methodType = "POST")
	public void createNewUser(){
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.post("/api/login");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.getStatusCode())
		         .isNotNull()
		         .isPositive()
		         .isEqualTo(200);
	}

	@Test(description = "Register new user")
	@FrameworkAnnotations(author = "Satya", category = "REGRESSION", methodType = "POST")
	public void newUserRegistartion() {
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "registerUser.json");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.post("/api/login");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.asString()				
				.contains("email"));               
	}
	
	@Test(description = "Register new user with invalid request",dependsOnMethods="verifyMissingPasswordValidation")
	@FrameworkAnnotations(author = "Mandeep", category = "REGRESSION", methodType = "POST")
	public void newUserRegistartionWithInvalidrequest(){
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "registerUser.json")
				.replace("pistol", "");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.post("/api/login");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.statusCode())
		.withFailMessage("Password is mandatory field to register a new user")
		.isNotNull()
		.isEqualTo(200);	               
	}
	
	@Test(description = "Check for status code in case of failure")
	@FrameworkAnnotations(author = "Mike", category = "REGRESSION", methodType = "POST")
	public void checkValidationCodeForMissingPassword(){
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "registerUser.json")
				.replace("pistol", "");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.post("/api/login");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.statusCode())
		.withFailMessage("Password is mandatory field to register a new user")
		.isNotNull()
		.isEqualTo("");	               
	}
	
	@Test(description = "Check missing password validation")
	@FrameworkAnnotations(author = "John", category = "REGRESSION", methodType = "POST")
	public void verifyMissingPasswordValidation() throws IOException {
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "registerUser.json")
				.replace("pistol", "");
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.post("/api/login");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.asString())
		.withFailMessage("Password missing validation is not as per requirement.")
		.isNotNull()
		.isEqualTo("Missing password");	               
	}
}
