package br.com.api_automation.controller.cep;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import br.com.api_automation.controller.BaseController;
import io.restassured.response.ValidatableResponse;

public class CepController extends BaseController {

	public static ValidatableResponse getCepByCodigoAndContentType(String codigo, String contentType) {
//		baseURI = "https://viacep.com.br/ws";
		
		return given()
				.spec(specController())
				.pathParam("cep", codigo).pathParam("content-type", contentType)
			.when()
				.get("/{cep}/{content-type}")
			.then()
				.assertThat()
					.log().ifValidationFails();
	}
	
	public static ValidatableResponse getCepByLocalidade(String estado, String cidade, String logradouro) {
		baseURI = "https://viacep.com.br/ws";
		
		return given()
				.spec(specController())
				.pathParam("estado", estado).pathParam("cidade", cidade).pathParam("logradouro", logradouro)
			.when()
				.get("/{estado}/{cidade}/{logradouro}/json")
			.then()
				.assertThat()
					.log().ifValidationFails();
	}
}
