package br.com.api_automation.controller;

import static io.restassured.RestAssured.given;

import io.restassured.response.ValidatableResponse;

public class CepController {

	public static ValidatableResponse getCepByCodigoAndContentType(String codigo, String contentType) {
		return given()
				.header("Content-Type", "application/json")
				.relaxedHTTPSValidation()
				.pathParam("cep", codigo).pathParam("content-type", contentType)
			.when()
				.get("/{cep}/{content-type}")
			.then()
				.assertThat()
					.log().ifValidationFails();
	}
	
	public static ValidatableResponse getCepByLocalidade(String estado, String cidade, String logradouro) {
		return given()
				.header("Content-Type", "application/json")
				.relaxedHTTPSValidation()
				.pathParam("estado", estado).pathParam("cidade", cidade).pathParam("logradouro", logradouro)
			.when()
				.get("/{estado}/{cidade}/{logradouro}/json")
			.then()
				.assertThat()
					.log().ifValidationFails();
	}
}
