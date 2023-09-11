package org.igt.utils;

import java.util.List;

import org.aeonbits.owner.Config;

@Config.Sources(value="file:${user.dir}/src/test/resources/config.properties")
public interface PropertyUtilOwnerLib extends Config {
	@Key("baseurl")
	String APIURL();
	@Key("URL")
	String WEBURL();
	@Key("LGAUNITYURL")
	String UNITYPAGEURL();
	String NOTIFICATIONURL();
	@Key("dashboardurl")
	String KIBANAURL();
	@Key("seleniumgridurl")
	String SELENIUMGRID();
	@Key("PORTALUSERNAME")
	String DTUSERNAME();
	@Key("PORTALPASSWORD")
	String DTPASSWORD();
	@Key("sendresultstoelk")
	Boolean ISREQTOSENDTOELASTIC();
	@DefaultValue("no")
	Boolean OVERRIDEREPORTS();
	Boolean PASSEDSTEPSSCREENSHOT();
	Boolean FAILEDSTEPSSCREENSHOT();
	@DefaultValue("no")
	Boolean skippedstepsscreenshot();
	Boolean failedretrytests();
	String browser();
	String RUNMODE();
	List<String> browserlist();
	
	@DefaultValue("no")
	Boolean SENDRESULTSTOTESTRAIL();
	String TESTRAILUSERNAME();
	String TESRRAILPASSWORD();
	String TESTRAILHOSTNAME();
	String TESTRAILTESTRUNID();

}
