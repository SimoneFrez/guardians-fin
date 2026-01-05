# GUARDIANS FIN // MONITOR DE EXPOSIÇÃO FGC

### SISTEMA DE CONTROLE DE RISCO E CONFORMIDADE FINANCEIRA
Este projeto consiste em uma API robusta desenvolvida em **Kotlin** e **Spring Boot**, projetada para mitigar riscos em aportes financeiros, validando a exposição do investidor em relação ao teto de garantia do **Fundo Garantidor de Créditos (FGC)**.

---

## ESTRUTURA ARQUITETURAL
O sistema utiliza princípios de **Clean Architecture**, garantindo a separação total entre as regras de negócio e os detalhes de infraestrutura.

* **DOMAIN LAYER**: Contém a lógica de negócio pura (Cálculo de Risco FGC) e as definições de interfaces.
* **APPLICATION LAYER**: Orquestra os fluxos de dados entre a Web e o Domínio.
* **INFRASTRUCTURE LAYER**: Implementação de persistência via Spring Data JPA e banco de dados H2.

---

## ESPECIFICAÇÕES TÉCNICAS

| COMPONENTE | TECNOLOGIA |
| :--- | :--- |
| LINGUAGEM | KOTLIN 2.1 |
| FRAMEWORK | SPRING BOOT 3.4 |
| PERSISTÊNCIA | SPRING DATA JPA / HIBERNATE |
| DATA SOURCE | H2 DATABASE (IN-MEMORY) |
| GERENCIADOR | GRADLE (KOTLIN DSL) |

---

## DIFERENCIAIS DE IMPLEMENTAÇÃO

### GLOBAL EXCEPTION HANDLER
Uso de `@RestControllerAdvice` para interceptar falhas e converter erros em objetos **ErrorResponse** padronizados, garantindo que a API nunca exponha detalhes sensíveis do servidor.

### VALIDATION ENGINE
Camada de validação rigorosa para integridade de dados (CPF, CNPJ e valores monetários) via Bean Validation.

---

## INTERFACE DE API (REST)

### PROCESSAR NOVO APORTE
`POST /api/v1/investimentos`

**EXEMPLO DE PAYLOAD:**
```json
{
  "cpf": "123.456.789-01",
  "cnpjEmissor": "00.111.222/0001-33",
  "valor": 150000.00,
  "tipo": "CDB"
}

RESPOSTA DE SUCESSO:

JSON

{
    "status": "Processado",
    "alerta_fgc": false,
    "percentual_uso": "60.00%"
}
PROCEDIMENTOS DE EXECUÇÃO

### INICIALIZAÇÃO VIA DOCKER (RECOMENDADO)
Para subir o ambiente completo de forma automatizada:
```powershell
docker-compose up --build

INICIALIZAÇÃO DO SERVIDOR
PowerShell

.\gradlew bootRun
ACESSO AO BANCO DE DADOS (H2 CONSOLE)
URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:guardiansdb

DESENVOLVIDO POR
SIMONE DA SILVA // ENGENHARIA DE SOFTWARE
