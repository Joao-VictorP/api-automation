package br.com.api_automation.steps;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

import org.apache.http.HttpStatus;

import br.com.api_automation.controller.cep.CepController;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.restassured.response.ValidatableResponse;

public class CepSteps {

	private String cep;
	private ValidatableResponse response;
	
	@Before
	public void setUp() {
		baseURI = "https://viacep.com.br/ws";
	}
	
	@Dado("que informamos um CEP válido")
	public void deve_informar_um_cep_valido() {
		this.cep = "01001000";
	}
	
	@Quando("buscamos os detalhes do CEP informado")
	public void deve_efetuar_uma_busca_pelo_cep() {
		this.response = CepController.getCepByCodigoAndContentType(this.cep, "json");
	}
	
	@Entao("são retornados os detalhes do correspondentes ao CEP")
	public void deve_validar_os_detalhes_retornados() {
		this.response.statusCode(HttpStatus.SC_OK)
		.assertThat()
			.body("cep", is("01001-000"))
			.body("logradouro", is("Praça da Sé"))
			.body("complemento", is("lado ímpar"))
			.body("bairro", is("Sé"))
			.body("localidade", is("São Paulo"))
			.body("uf", is("SP"))
			.body("ibge", is("3550308"))
			.body("gia", is("1004"))
			.body("ddd", is("11"))
			.body("siafi", is("7107"))
			.body(matchesJsonSchemaInClasspath("schema-validator/cep-validator.json"));
	}
}
