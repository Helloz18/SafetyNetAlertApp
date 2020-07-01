package com.hfinoux.SafetyNetAlerts;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@SpringBootApplication
@ComponentScan(basePackages={"controller"})
public class SafetyNetAlertsApplication {

	private static Logger logger = LogManager.getLogger(SafetyNetAlertsApplication.class);

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
	}

}
