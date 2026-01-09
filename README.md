# KD1K turbo API (Gestão Seção de Pessoal - CBMPE)

Aplicação backend Java desenvolvida para auxiliar no gerenciamento da Seção de Pessoal de um Quartel do Corpo de Bombeiros Militar de Pernambuco (CBMPE).

## 🚒 Sobre o Projeto

Este sistema tem como objetivo modernizar e facilitar as rotinas administrativas da Seção de Pessoal (B-1/P-1), oferecendo uma API robusta para controle de efetivo, escalas, frequências e demais processos administrativos da caserna.

### Funcionalidades Principais (Previstas/Implementadas)
*   **Gestão de Efetivo:** Cadastro e controle de militares.
*   **Controle de Frequência:** Gerenciamento de apresentações, dispensas e licenças.
*   **Escalas:** Suporte ao planejamento e consulta de escalas de serviço.
*   **Relatórios Administrativos:** Geração de dados para auxiliar na tomada de decisão.

## 🛠 Tecnologias Utilizadas

*   **Java 17:** Linguagem base do projeto.
*   **Spring Boot 3.4.4:** Framework principal para desenvolvimento ágil.
    *   *Spring Web:* Para construção da API REST.
    *   *Spring Data JPA:* Persistência de dados simplificada.
    *   *Spring Validation:* Validação de regras de negócio.
*   **PostgreSQL:** Banco de dados relacional robusto.
*   **Flyway:** Versionamento e migração de banco de dados.
*   **Lombok:** Redução de código boilerplate.
*   **Docker & Docker Compose:** Containerização para fácil implantação.
*   **Swagger / OpenAPI:** Documentação interativa da API.

## 🚀 Como Executar

### Pré-requisitos
*   Java 17+
*   Maven 3.8+
*   Docker & Docker Compose (Recomendado)

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/allysonhalley/kd1k-turbo-api.git
    cd kd1k-turbo-api
    ```

2.  **Executando com Docker (Recomendado):**
    O projeto já está configurado com `docker-compose` para subir a aplicação e o banco de dados PostgreSQL automaticamente.
    ```bash
    docker-compose up -d --build
    ```
    A API estará disponível em: `http://localhost:8081`

3.  **Executando Manualmente (Maven):**
    Caso prefira rodar localmente sem Docker para a aplicação (necessário ter um Postgres rodando):
    
    *   Certifique-se que o banco de dados está acessível nas configurações de ambiente (ver `src/main/resources/application.properties` ou variáveis de ambiente).
    *   Execute:
        ```bash
        ./mvnw spring-boot:run
        ```

## 📚 Documentação da API

A documentação interativa (Swagger UI) pode ser acessada após iniciar a aplicação em:

*   **URL Local:** [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)
*   **JSON Docs:** [http://localhost:8081/v3/api-docs](http://localhost:8081/v3/api-docs)

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir _issues_ para discutir novas funcionalidades ou _pull requests_ para melhorias.

---
_Desenvolvido para apoio administrativo ao CBMPE._
