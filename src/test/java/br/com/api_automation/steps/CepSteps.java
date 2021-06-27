package br.com.api_automation.steps;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;

import br.com.api_automation.AutomationUtil;
import br.com.api_automation.controller.cep.CepController;
import cucumber.api.DataTable;
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
		baseURI = AutomationUtil.getProperty("enviroment.url");
	}
	
	@Dado("que informamos um (.*) válido")
	public void deve_informar_um_cep_valido(String cep) {
		this.cep = cep;
	}
	
	@Dado("que informamos um (.*) com mais de oito digitos")
	public void deve_informar_um_cep_com_mais_de_oito_digitos(String cep) {
		this.cep = cep;
	}
	
	@Dado("que informamos um (.*) alfanumérico")
	public void deve_informar_um_cep_alfanumerico(String cep) {
		this.cep = cep;
	}
	
	@Dado("que informamos um (.*) com espaço entre os números")
	public void deve_informar_cep_com_espacos(String cep) {
		this.cep = cep;
	}

	@Dado("que informamos um (.*) inválido")
	public void deve_informar_um_cep_invalido(String cep) {
		this.cep = cep;
	}
	
	@Dado("que informamos um (.*) mascarado")
	public void deve_informar_um_cep_mascarado(String cep) {
		this.cep = cep;
	}
	
	@Dado("que não informamos um CEP")
	public void nao_deve_informar_um_cep() {
		this.cep = "";
	}
		
	@Quando("buscamos os detalhes do CEP informado")
	public void deve_efetuar_uma_busca_pelo_cep() {
		this.response = CepController.getCepByCodigoAndContentType(this.cep, "json");
	}
	
	@Entao("são retornados os detalhes do correspondentes ao CEP")
	public void deve_validar_os_detalhes_retornados(DataTable params) {
		List<Map<Object, Object>> ceps = params.asMaps(null, null);
		
		this.response.statusCode(HttpStatus.SC_OK)
		.assertThat()
			.body("cep", is(ceps.get(0)))
			.body("logradouro", is(ceps.get(1)))
			.body("complemento", is(ceps.get(2)))
			.body("bairro", is(ceps.get(3)))
			.body("localidade", is(ceps.get(4)))
			.body("uf", is(ceps.get(5)))
			.body("ibge", is(ceps.get(6)))
			.body("gia", is(ceps.get(7)))
			.body("ddd", is(ceps.get(8)))
			.body("siafi", is(ceps.get(9)))
			.body(matchesJsonSchemaInClasspath("schema-validator/cep-validator.json"));
	}
	
	@Entao("não são retornados detalhes")
	public void nao_deve_retorna_detalhes() {
		this.response.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Entao("é retornado erro")
	public void deve_retornar_um_erro() {
		this.response.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body("erro", is(true));
	}
}
