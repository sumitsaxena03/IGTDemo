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

public class UpdateTest {

	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentASIADateTimeFormat() + "]");
	}

	@Test(description = "Updating user details")
	@FrameworkAnnotations(author = "Mike", category = "SMOKE", methodType = "PUT")
	public void updateRequest() {
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json")
				.replace("cityslicka", RandomDataUtils.getFirstName());
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.put("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		ApiUtils.saveReturnedPostResponse(FrameworkConstants.responsejsonfolderpath + "response.json", response);
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
	}
	
	@Test(description = "Validating update response")
	@FrameworkAnnotations(author = "John", category = "SMOKE", methodType = "PUT")
	public void updateRequestToValidateUserDetails() {
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json")
				.replace("cityslicka", RandomDataUtils.getFirstName());
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.put("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		ApiUtils.saveReturnedPostResponse(FrameworkConstants.responsejsonfolderpath + "response.json", response);
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.asString().contains("email"));
	}
	
	@Test(description = "Verify first name after update")
	@FrameworkAnnotations(author = "Aravind", category = "QUICKREGRESSION", methodType = "PUT")
	public void validateFirstNameAfterUpdate() {
		String randomname =RandomDataUtils.getFirstName();
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json")
				.replace("cityslicka", randomname);
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.put("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		ApiUtils.saveReturnedPostResponse(FrameworkConstants.responsejsonfolderpath + "response.json", response);
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.asString().contains(randomname));
	}
	
	@Test(description = "Check last name after update")
	@FrameworkAnnotations(author = "Mandeep", category = "REGRESSION", methodType = "PUT")
	public void checkLastNameAfterUpdation() {
		String randomname =RandomDataUtils.getLastName();
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json")
				.replace("cityslicka", randomname);
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.put("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		ApiUtils.saveReturnedPostResponse(FrameworkConstants.responsejsonfolderpath + "response.json", response);
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.asString().contains(randomname));
	}
	
	@Test(description = "Verify response body")
	@FrameworkAnnotations(author = "Sumit", category = "SMOKE", methodType = "PUT")
	public void verifyResponseBody() {
		String randomname =RandomDataUtils.getLastName();
		String request = ApiUtils.readFromExternalFile(FrameworkConstants.requestjsonfolderpath + "createUser.json")
				.replace("cityslicka", randomname);
		RequestSpecification reqspecification = RequestBuilder.buildRequestForPostCalls().body(request);
		ExtentLogger.logRequest(reqspecification);
		Response response = reqspecification.put("/api/users/2");
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		System.out.println(response.asPrettyString());
		ApiUtils.saveReturnedPostResponse(FrameworkConstants.responsejsonfolderpath + "response.json", response);
		log(CONSOLEANDEXTENTINFO, "API response is : " + response.getStatusCode());
		Assertions.assertThat(response.asPrettyString().isBlank());
	}

}
