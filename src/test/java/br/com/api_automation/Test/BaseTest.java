package br.com.api_automation.Test;

import static io.restassured.RestAssured.baseURI;

import org.junit.Before;

public class BaseTest {

	@Before
	public void setUp() {
		baseURI = "https://viacep.com.br/ws";
	}
	
}
