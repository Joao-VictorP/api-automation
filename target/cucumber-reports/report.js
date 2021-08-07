$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/cep.feature");
formatter.feature({
  "name": "Funcionalidade responsável por listar os CEP\u0027s através do código",
  "description": "",
  "keyword": "Funcionalidade"
});
formatter.scenarioOutline({
  "name": "Verificar na API CepResource se ao listarmos um CEP válido são retornados os detalhes correspondentes ao CEP informado",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@listaCepValido"
    }
  ]
});
formatter.step({
  "name": "que informamos um \u003cCEP\u003e válido",
  "keyword": "Dado "
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.step({
  "name": "são retornados os detalhes correspondentes ao CEP",
  "keyword": "Entao ",
  "rows": [
    {
      "cells": [
        "cep",
        "logradouro",
        "complemento",
        "bairro",
        "localidade",
        "uf",
        "ibge",
        "gia",
        "ddd",
        "siafi"
      ]
    },
    {
      "cells": [
        "01001-000",
        "Praça da Sé",
        "lado ímpar",
        "Sé",
        "São Paulo",
        "SP",
        "3550308",
        "1004",
        "11",
        "7107"
      ]
    }
  ]
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "CEP"
      ]
    },
    {
      "cells": [
        "01001000"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verificar na API CepResource se ao listarmos um CEP válido são retornados os detalhes correspondentes ao CEP informado",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@listaCepValido"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que informamos um 01001000 válido",
  "keyword": "Dado "
});
formatter.match({
  "location": "CepSteps.deve_informar_um_cep_valido(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.match({
  "location": "CepSteps.deve_efetuar_uma_busca_pelo_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "são retornados os detalhes correspondentes ao CEP",
  "rows": [
    {
      "cells": [
        "cep",
        "logradouro",
        "complemento",
        "bairro",
        "localidade",
        "uf",
        "ibge",
        "gia",
        "ddd",
        "siafi"
      ]
    },
    {
      "cells": [
        "01001-000",
        "Praça da Sé",
        "lado ímpar",
        "Sé",
        "São Paulo",
        "SP",
        "3550308",
        "1004",
        "11",
        "7107"
      ]
    }
  ],
  "keyword": "Entao "
});
formatter.match({
  "location": "CepSteps.deve_validar_os_detalhes_retornados(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verificar na API CepResource se ao listarmos um CEP com mais de 8 digítos não são retornados CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepComOitoDigitos"
    }
  ]
});
formatter.step({
  "name": "que informamos um \u003cCEP\u003e com mais de oito digitos",
  "keyword": "Dado "
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.step({
  "name": "não são retornados detalhes",
  "keyword": "Entao "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "CEP"
      ]
    },
    {
      "cells": [
        "010010008"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verificar na API CepResource se ao listarmos um CEP com mais de 8 digítos não são retornados CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepComOitoDigitos"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que informamos um 010010008 com mais de oito digitos",
  "keyword": "Dado "
});
formatter.match({
  "location": "CepSteps.deve_informar_um_cep_com_mais_de_oito_digitos(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.match({
  "location": "CepSteps.deve_efetuar_uma_busca_pelo_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "não são retornados detalhes",
  "keyword": "Entao "
});
formatter.match({
  "location": "CepSteps.nao_deve_retorna_detalhes()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verificar na API CepResource se ao listarmos um CEP alfanumérico não são retornados CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepAlfanumerico"
    }
  ]
});
formatter.step({
  "name": "que informamos um \u003cCEP\u003e alfanumérico",
  "keyword": "Dado "
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.step({
  "name": "não são retornados detalhes",
  "keyword": "Entao "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "CEP"
      ]
    },
    {
      "cells": [
        "010010F0"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verificar na API CepResource se ao listarmos um CEP alfanumérico não são retornados CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepAlfanumerico"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que informamos um 010010F0 alfanumérico",
  "keyword": "Dado "
});
formatter.match({
  "location": "CepSteps.deve_informar_um_cep_alfanumerico(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.match({
  "location": "CepSteps.deve_efetuar_uma_busca_pelo_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "não são retornados detalhes",
  "keyword": "Entao "
});
formatter.match({
  "location": "CepSteps.nao_deve_retorna_detalhes()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verificar na API CepResource se ao listarmos um CEP com espaços não são retorandos CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepComEspaco"
    }
  ]
});
formatter.step({
  "name": "que informamos um \u003cCEP\u003e com espaço entre os números",
  "keyword": "Dado "
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.step({
  "name": "não são retornados detalhes",
  "keyword": "Entao "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "CEP"
      ]
    },
    {
      "cells": [
        "01001 000"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verificar na API CepResource se ao listarmos um CEP com espaços não são retorandos CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepComEspaco"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que informamos um 01001 000 com espaço entre os números",
  "keyword": "Dado "
});
formatter.match({
  "location": "CepSteps.deve_informar_cep_com_espacos(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.match({
  "location": "CepSteps.deve_efetuar_uma_busca_pelo_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "não são retornados detalhes",
  "keyword": "Entao "
});
formatter.match({
  "location": "CepSteps.nao_deve_retorna_detalhes()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verificar na API CepResource se ao listarmos um CEP inválido não são retornados CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepInvalido"
    }
  ]
});
formatter.step({
  "name": "que informamos um \u003cCEP\u003e inválido",
  "keyword": "Dado "
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.step({
  "name": "é retornado erro",
  "keyword": "Entao "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "CEP"
      ]
    },
    {
      "cells": [
        "01001243"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verificar na API CepResource se ao listarmos um CEP inválido não são retornados CEP\u0027s",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@naoListaCepInvalido"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que informamos um 01001243 inválido",
  "keyword": "Dado "
});
formatter.match({
  "location": "CepSteps.deve_informar_um_cep_invalido(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.match({
  "location": "CepSteps.deve_efetuar_uma_busca_pelo_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "é retornado erro",
  "keyword": "Entao "
});
formatter.match({
  "location": "CepSteps.deve_retornar_um_erro()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Verificar na API CepResource se ao listarmos um CEP mascarado são retornados os detalhes correspondentes ao CEP informado",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@listaCepMascarado"
    }
  ]
});
formatter.step({
  "name": "que informamos um \u003cCEP\u003e mascarado",
  "keyword": "Dado "
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.step({
  "name": "são retornados os detalhes correspondentes ao CEP",
  "keyword": "Entao ",
  "rows": [
    {
      "cells": [
        "cep",
        "logradouro",
        "complemento",
        "bairro",
        "localidade",
        "uf",
        "ibge",
        "gia",
        "ddd",
        "siafi"
      ]
    },
    {
      "cells": [
        "01325-070",
        "Avenida Radial Leste-Oeste",
        "",
        "Bela Vista",
        "São Paulo",
        "SP",
        "3550308",
        "1004",
        "11",
        "7107"
      ]
    }
  ]
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Exemplos",
  "rows": [
    {
      "cells": [
        "CEP"
      ]
    },
    {
      "cells": [
        "01325-070"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Verificar na API CepResource se ao listarmos um CEP mascarado são retornados os detalhes correspondentes ao CEP informado",
  "description": "",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "name": "@listaCepMascarado"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que informamos um 01325-070 mascarado",
  "keyword": "Dado "
});
formatter.match({
  "location": "CepSteps.deve_informar_um_cep_mascarado(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.match({
  "location": "CepSteps.deve_efetuar_uma_busca_pelo_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "são retornados os detalhes correspondentes ao CEP",
  "rows": [
    {
      "cells": [
        "cep",
        "logradouro",
        "complemento",
        "bairro",
        "localidade",
        "uf",
        "ibge",
        "gia",
        "ddd",
        "siafi"
      ]
    },
    {
      "cells": [
        "01325-070",
        "Avenida Radial Leste-Oeste",
        "",
        "Bela Vista",
        "São Paulo",
        "SP",
        "3550308",
        "1004",
        "11",
        "7107"
      ]
    }
  ],
  "keyword": "Entao "
});
formatter.match({
  "location": "CepSteps.deve_validar_os_detalhes_retornados(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verificar na API CepResource se ao listarmos um CEP não informando o CEP não são retornados CEP\u0027s",
  "description": "",
  "keyword": "Cenario",
  "tags": [
    {
      "name": "@naoListaCepNulo"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "que não informamos um CEP",
  "keyword": "Dado "
});
formatter.match({
  "location": "CepSteps.nao_deve_informar_um_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "buscamos os detalhes do CEP informado",
  "keyword": "Quando "
});
formatter.match({
  "location": "CepSteps.deve_efetuar_uma_busca_pelo_cep()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "não são retornados detalhes",
  "keyword": "Entao "
});
formatter.match({
  "location": "CepSteps.nao_deve_retorna_detalhes()"
});
formatter.result({
  "status": "passed"
});
});