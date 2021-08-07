package br.com.api_automation.steps;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;

import br.com.api_automation.controller.cep.CepController;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.response.ValidatableResponse;

public class CepSteps {

	private String cep;
	private ValidatableResponse response;
	
	
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
	
	@Entao("são retornados os detalhes correspondentes ao CEP")
	public void deve_validar_os_detalhes_retornados(DataTable params) {
		List<Map<String, String>> cepList = params.asMaps(String.class, String.class);
		
		cepList.forEach(cep -> {
			this.response.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body("cep", is(cep.get("cep")))
				.body("logradouro", is(cep.get("logradouro")))
				.body("complemento", is(cep.get("complemento")))
				.body("bairro", is(cep.get("bairro")))
				.body("localidade", is(cep.get("localidade")))
				.body("uf", is(cep.get("uf")))
				.body("ibge", is(cep.get("ibge")))
				.body("gia", is(cep.get("gia")))
				.body("ddd", is(cep.get("ddd")))
				.body("siafi", is(cep.get("siafi")))
				.body(matchesJsonSchemaInClasspath("schema-validator/cep-validator.json"));
		});
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
