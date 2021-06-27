package br.com.api_automation.tests.cep;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.junit.Test;

import br.com.api_automation.controller.cep.CepController;
import br.com.api_automation.tests.BaseTest;
import io.restassured.response.ValidatableResponse;

public class CepTest extends BaseTest {

	private static final Logger LOGGER = Logger.getLogger(CepTest.class);
	
	@Test
	public void deveRetornarOsDetalhesDeUmCEP () {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos um CEP válido são retornados os detalhes correspondentes ao CEP informado");
		
		ValidatableResponse response = CepController.getCepByCodigoAndContentType("01001000", "json");
		response.statusCode(HttpStatus.SC_OK)
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
	
	@Test
	public void naoDeveRetornarDetalhesParaCepComMaisDeOitoDigitos() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos um CEP com mais de 8 digítos não são retornados CEP's");
		
		ValidatableResponse response = CepController.getCepByCodigoAndContentType("010010008", "json");
		response.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Test
	public void naoDeveRetornarDetalhesParaCepAlfaNumerico() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos um CEP alfanumérico não são retornados CEP's");
		
		ValidatableResponse response = CepController.getCepByCodigoAndContentType("010010F0", "json");
		response.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Test
	public void naoDeveRetornarDetalhesParaCepComEspaco() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos um CEP com espaços não são retorandos CEP's");
		
		ValidatableResponse response = CepController.getCepByCodigoAndContentType("01001 000", "json");
		response.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Test
	public void naoDeveRetornarDetalhesParaCepInvalido() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos um CEP inválido não são retornados CEP's");
		
		ValidatableResponse response = CepController.getCepByCodigoAndContentType("01001243", "json");
		response.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body("erro", is(true));
	}
	
	@Test
	public void deveRetornarDetalhesParaCepMascarado() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos um CEP mascarado são retornados os detalhes correspondentes ao CEP informado");
		
		ValidatableResponse response = CepController.getCepByCodigoAndContentType("01325-070", "json");
		response.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body("cep", is("01325-070"))
				.body("logradouro", is("Avenida Radial Leste-Oeste"))
				.body("complemento", is(""))
				.body("bairro", is("Bela Vista"))
				.body("localidade", is("São Paulo"))
				.body("uf", is("SP"))
				.body("ibge", is("3550308"))
				.body("gia", is("1004"))
				.body("ddd", is("11"))
				.body("siafi", is("7107"))
				.body(matchesJsonSchemaInClasspath("schema-validator/cep-validator.json"));
	}
	
	@Test
	public void naoDeveRetornarDetalhesAoNaoInformarCep() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos um CEP não informando o CEP não são retornados CEP's");
		
		ValidatableResponse response = CepController.getCepByCodigoAndContentType("", "json");
		response.statusCode(HttpStatus.SC_BAD_REQUEST);
	}
	
	@Test
	public void deveRetornarDetalhesAoInformarLocalidade() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos uma localidade válida são retornados os detalhes correspondentes");
		
		ValidatableResponse response = CepController.getCepByLocalidade("RS", "Porto Alegre", "Domingos");
		response.statusCode(HttpStatus.SC_OK)
			.assertThat()
				.body(matchesJsonSchemaInClasspath("cep-validator-array.json"));
	}
	
	@Test
	public void naoDeveRetornarDetalhesAoInformarCidadeNaoCorrespondenteAoEstado() {
		CepTest.LOGGER.info("Verificar na API CepResource se ao listarmos uma localidade informando uma cidade não correspondente ao estado não são retornados CEP's");
		
		ValidatableResponse response = CepController.getCepByLocalidade("RS", "São Paulo", "Domingos");
		response.statusCode(HttpStatus.SC_OK);
	}
}
