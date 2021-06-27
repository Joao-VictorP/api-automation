#language: pt

Funcionalidade: Funcionalidade responsável por listar os CEP's através do código

	@listaCepValido
	Cenario: Verificar na API CepResource se ao listarmos um CEP válido são retornados os detalhes correspondentes ao CEP informado
		Dado que informamos um CEP válido
		Quando buscamos os detalhes do CEP informado
		Entao são retornados os detalhes do correspondentes ao CEP
		