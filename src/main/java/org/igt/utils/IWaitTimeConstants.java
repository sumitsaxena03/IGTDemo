package org.igt.utils;

import java.time.Duration;

import org.igt.drivers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * interface which provides the wait time constants to be used in the framework.
 * 
 * @author Sumit.Saxena
 *
 */
public interface IWaitTimeConstants {
	/** Global int wait one seconds (minimum). */
    int GLOBAL_WAIT_TIME_MIN = 1;
    /** Global int wait 10 seconds. */
    int GLOBAL_WAIT_TIME = 10;
    /** Global int timeout which is the timeout in the wait.until() methods. */
    Duration GLOBAL_SYNCHRONISATION_TIMEOUT = Duration.ofSeconds(180); 
    /** Global wait time for the maximum wait time in seconds. */
    int GLOBAL_WAIT_TIME_MAX = 70; 

    /** Global minimum wait time in seconds to pause. */
    int GLOBAL_MAX_WAIT_TIME_SEC = 180;
    
    /** MILLI-SECONDS (MS). */
    
    /** Global minimum wait time in ms to pause (tenth of a second). */
    int GLOBAL_MINIMUM_WAIT_TIME_MS = 100;
    /** Global wait time in ms to pause a second. */
    int GLOBAL_WAIT_TIME_HALF_SEC_IN_MS = 500;
    /** Global wait time in ms to pause a second. */
    int GLOBAL_WAIT_TIME_ONE_SEC_IN_MS = 1000;
    /** Global wait time in ms to pause a second. */
    int GLOBAL_WAIT_TIME_TWO_SEC_IN_MS = 2000;
    /** Global wait time in MS. */
    int GLOBAL_WAIT_TIME_MS = 5000;
    /** Global wait time in ms to pause 10 second. */
    int GLOBAL_WAIT_TIME_TEN_SEC_IN_MS = 10000;
    /** Global wait time in ms to pause 30 second. */
    int GLOBAL_WAIT_TIME_THIRTY_SEC_IN_MS = 30000;
    /** Global wait time for the maximum wait time in seconds. */
    int GLOBAL_WAIT_TIME_MAX_MS = 60000;
    /** Global HUD Wait time in ms.**/
    int GLOBAL_WAIT_TIME_HUD_MS = 1500;
}