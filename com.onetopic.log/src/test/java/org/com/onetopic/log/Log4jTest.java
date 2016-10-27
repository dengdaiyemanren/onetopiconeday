package org.com.onetopic.log;

import org.junit.After;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

public class Log4jTest {

	static String CONFIG_FILE_KEY = "log4j.configuration";

	@Before
	public void setup() {
		System.setProperty(CONFIG_FILE_KEY, "log4j.xml");

	}

	@After
	public void tearDown() throws Exception {
		System.clearProperty(CONFIG_FILE_KEY);
	}
	
	@Test
	public void testSimple()
	{
		  Logger logger = LoggerFactory.getLogger("Log4jTest");
	      logger.debug("Hello world.");
	}
	
	@Test
	public void testArg()
	{
		  Logger logger = LoggerFactory.getLogger("Log4jTest");
		  
		  int i =10;
	      logger.debug("Hello {} world.",i);
	}
	

}
