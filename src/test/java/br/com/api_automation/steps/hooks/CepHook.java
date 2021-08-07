package br.com.api_automation.steps.hooks;

import static io.restassured.RestAssured.baseURI;

import br.com.api_automation.AutomationUtil;
import io.cucumber.java.Before;

public class CepHook {

	@Before
	public void setUp() {
		baseURI = AutomationUtil.getProperty("enviroment.url");
	}
	
}
