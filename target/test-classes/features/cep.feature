#language: pt

Funcionalidade: Funcionalidade responsável por listar os CEP's através do código

	Contexto:
		Quando buscamos os detalhes do CEP informado

	@listaCepValido
	Esquema do Cenario: Verificar na API CepResource se ao listarmos um CEP válido são retornados os detalhes correspondentes ao CEP informado
		Dado que informamos um <CEP> válido
		Entao são retornados os detalhes do correspondentes ao CEP
			|			cep			|		logradouro	|	 complemento |bairro|	localidade	|	 uf  |		ibge	 |	 gia	|	 ddd | siafi	|
			| '01001-000' | 'Praça da Sé' | 'lado ímpar' | 'Sé' | 'São Paulo' | 'SP' | '3550308' | '1004' | '11' | '7107' |
		
		Exemplos:
		|		  CEP	   |
		| '01001000' |

	@naoListaCepComOitoDigitos
	Esquema do Cenario: Verificar na API CepResource se ao listarmos um CEP com mais de 8 digítos não são retornados CEP's
		Dado que informamos um <CEP> com mais de oito digitos
		Entao não são retornados detalhes
		
		Exemplos:
		|		  CEP 	  |
		| '010010008' |
	
	@naoListaCepAlfanumerico
	Esquema do Cenario: Verificar na API CepResource se ao listarmos um CEP alfanumérico não são retornados CEP's
		Dado que informamos um <CEP> alfanumérico
		Entao não são retornados detalhes
			
		Exemplos:
		|		  CEP	   |
		| '010010F0' |
	
	@naoListaCepComEspaco
	Esquema do Cenario: Verificar na API CepResource se ao listarmos um CEP com espaços não são retorandos CEP's
		Dado que informamos um <CEP> com espaço entre os números
		Entao não são retornados detalhes
		
		Exemplos:
		|		  CEP	    |
		| '01001 000' |
	
	@naoListaCepInvalido
	Esquema do Cenario: Verificar na API CepResource se ao listarmos um CEP inválido não são retornados CEP's
		Dado que informamos um <CEP> inválido
		Entao é retornado erro
		
		Exemplos:
		|		  CEP	   |
		| '01001243' |
		
	@listaCepMascarado
	Esquema do Cenario: Verificar na API CepResource se ao listarmos um CEP mascarado são retornados os detalhes correspondentes ao CEP informado
		Dado que informamos um <CEP> mascarado
		Entao são retornados os detalhes do correspondentes ao CEP
			|			cep			|		logradouro			|	 complemento  |			bairro	 |	localidade |  uf  |	 	 ibge	  |	  gia	 |	ddd |  siafi |
			| '01325-070' | 'Avenida Radial Leste-Oeste' | '' | 'Bela Vista' | 'São Paulo' | 'SP' | '3550308' | '1004' | '11' | '7107' |
		
		Exemplos:
		|		  CEP 	  |
		| '01325-070' |
		
	@naoListaCepNulo
	Cenario: Verificar na API CepResource se ao listarmos um CEP não informando o CEP não são retornados CEP's 
		Dado que não informamos um CEP
		Entao não são retornados detalhes
