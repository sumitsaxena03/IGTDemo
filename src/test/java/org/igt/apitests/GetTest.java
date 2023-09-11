package org.igt.apitests;

import static io.restassured.RestAssured.*;
import static org.igt.reports.FrameworkLogger.log;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.igt.annotations.FrameworkAnnotations;
import org.igt.enums.CategoryType;
import org.igt.enums.LogType;
import org.igt.reports.ExtentLogger;
import org.igt.reports.ExtentManager;
import org.igt.reports.ExtentReport;
import org.igt.requestbuilder.RequestBuilder;
import org.igt.utils.DateFormatUtils;

import io.restassured.response.Response;

public class GetTest {

	@BeforeMethod
	public static void beforeTest(ITestResult result) {
		log(LogType.CONSOLE, "TEST STARTED : " + result.getMethod().getMethodName() + " at ["
				+ DateFormatUtils.currentASIADateTimeFormat() + "]");
	}

	@Test(description = "Get List of Users")
	@FrameworkAnnotations(author = "Mandeep", category = "SMOKE", methodType = "GET")
	public void getUserDetails() {
		Response response = RequestBuilder.buildRequestForGetCalls().get("/api/users?page=2");
		response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		Assertions.assertThat(response.getStatusCode()).as("Checking status code").isEqualTo(200).isNotEqualTo(201)
				.isNotNull();
	}
	
	@Test(description = "List down total page count")
	@FrameworkAnnotations(author = "Mandeep", category = "SMOKE", methodType = "GET")
	public void getPageCount() {
		Response response = RequestBuilder.buildRequestForGetCalls().get("/api/users?page=2");
		response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		Object ss =response.jsonPath().get("total");		
		Assertions.assertThat(ss).isEqualTo(12);
	}
	
	@Test(description = "Check content type of get user details")
	@FrameworkAnnotations(author = "Mandeep", category = "QUICKREGRESSION", methodType = "GET")
	public void checkContentForGetUser() { 
		Response response = RequestBuilder.buildRequestForGetCalls().get("/api/users?page=2");
		response.prettyPrint(); 
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		Assertions.assertThat(response.getStatusCode()).as("Checking status code").isEqualTo(200).isNotEqualTo(201)
				.isNotNull();
		 Assertions.assertThat(response.header("Content-Type"))
		 .isEqualTo("application/json; charset=utf-8");
	}
	
	@Test(description = "Check user name title")
	@FrameworkAnnotations(author = "Satya", category = "QUICKREGRESSION", methodType = "GET")
	public void checkUserTitle() {
		Response response = RequestBuilder.buildRequestForGetCalls().get("/api/users?page=2");
		response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
		ExtentLogger.logResponseTime(String.valueOf(response.getTimeIn(TimeUnit.MILLISECONDS)));
		Assertions.assertThat(response.asString().contains("first_name"));
	}
}
