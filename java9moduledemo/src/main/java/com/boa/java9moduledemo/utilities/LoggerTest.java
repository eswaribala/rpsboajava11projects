package com.boa.java9moduledemo.utilities;

import java.util.logging.Logger;

public class LoggerTest {

	 private static final Logger LOGGER = Logger.getLogger(LoggerTest.class.getName());

	  public static void main(String[] args) {
	      LOGGER.info("Running test application..");
	  }

}
