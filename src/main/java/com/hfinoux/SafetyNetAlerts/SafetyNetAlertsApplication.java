package com.hfinoux.SafetyNetAlerts;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@SpringBootApplication
@ComponentScan(basePackages={"com.hfinoux.SafetyNetAlerts.controller","com.hfinoux.SafetyNetAlerts.dao"})
public class SafetyNetAlertsApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		SpringApplication.run(SafetyNetAlertsApplication.class, args);
		}

}
