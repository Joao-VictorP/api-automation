package br.com.api_automation.controller;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseController {

	public static RequestSpecification specController() {
		return new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation()
				.build();
	}
	
}
