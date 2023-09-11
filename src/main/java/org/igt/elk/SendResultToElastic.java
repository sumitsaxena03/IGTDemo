package org.igt.elk;

import static io.restassured.RestAssured.given;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.igt.constants.FrameworkConstants;
import org.igt.enums.PropertiesType;
import org.igt.requestbuilder.RequestBuilder;
import org.igt.utils.PropertyUtils;
import org.testng.Assert;

import io.restassured.response.Response;

/**
 * Send test execution status to elastic store to display these data on Kibana dashboard to see live execution.
 * Mar 14, 2022
 * @author Mandeep Sheoran
 * @version 1.0
 * @since 1.0
 * @see PropertiesType
 * @see PropertyUtils
 */
public class SendResultToElastic {
	
	public static void sendstatustoelastic(String testname, String status) {		
		if(PropertyUtils.getValue((String.valueOf(PropertiesType.SENDRESULTSTOELK)).toLowerCase()).equalsIgnoreCase("yes")) {		
			Map<String,String> map = new HashMap<>();
			map.put("TestCaseName", testname);
			map.put("TestStatus", status);
			map.put("executiontime", LocalDateTime.now().toString());
			
			Response response = given().header("Content-Type", "application/json")
					.log()
					.all()
					.body(map)
					.post(PropertyUtils.getValue(((String.valueOf(PropertiesType.DASHBOARDURL)).toLowerCase())));

			Assert.assertEquals(response.statusCode(), 201);
			response.prettyPrint();
		} else {
			System.out.println("Config key to send results to ElasticSearch is off hence not sending data to Elastic");
		}		
	}
}
