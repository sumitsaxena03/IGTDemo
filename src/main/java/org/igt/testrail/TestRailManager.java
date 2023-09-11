package org.igt.testrail;


import java.util.HashMap;
import java.util.Map;

import org.apache.poi.util.SystemOutLogger;
import org.igt.enums.PropertiesType;
import org.igt.utils.PropertyUtils;

public class TestRailManager {

	public static String TEST_RAIL_ENGINE_URL = PropertyUtils.getValue((String.valueOf(PropertiesType.TESTRAILHOSTNAME)));
	public static String TEST_RAIL_USERNAME = PropertyUtils.getValue((String.valueOf(PropertiesType.TESTRAILUSERNAME)));
	public static String TEST_RAIL_PASSWORD = PropertyUtils.getValue((String.valueOf(PropertiesType.TESRRAILPASSWORD)));
	public static String TEST_RUN_ID = PropertyUtils.getValue((String.valueOf(PropertiesType.TESTRAILTESTRUNID)));
	public static int TEST_CASE_PASS_STATUS = 1;
	public static int TEST_CASE_FAIL_STATUS = 5;
	public static int TEST_CASE_SKIP_STATUS = 3;


	public static void sendResultsToTestrail(String testCaseId, int status, String comments) {

		if(PropertyUtils.getValue((String.valueOf(PropertiesType.SENDRESULTSTOTESTRAIL)).toLowerCase()).equalsIgnoreCase("yes")) {
			
			 System.out.println("Inside sendResultsToTestrail");
			 
			//DisableSSLVerification.disableSSLVerification();

			//String testRunID = TEST_RUN_ID;
			String testRunID = "6550";

			APIClient client = new APIClient(TEST_RAIL_ENGINE_URL);
			client.setUser(TEST_RAIL_USERNAME);
			client.setPassword(TEST_RAIL_PASSWORD);

			Map<String, Object> data = new HashMap<String, Object>();
			data.put("status_id", status);
			data.put("comment", comments);

			try {
				client.sendPost("add_result_for_case/" + testRunID + "/" + testCaseId, data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Config key to send results to TestRail is off hence not sending data to TestRail");
		}
	}
}
