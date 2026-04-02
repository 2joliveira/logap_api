# Logap API

Uma API REST desenvolvida com Spring Boot para gerenciamento de manutenções de veículos.

## Descrição

Esta aplicação fornece endpoints para agendar manutenções de veículos e visualizar um dashboard com métricas relacionadas a viagens, uso de veículos e projeções financeiras.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.13**
- **Spring Data JPA**
- **H2 Database** (para desenvolvimento e testes)
- **Maven** (gerenciamento de dependências)

## Pré-requisitos

- Java 17 ou superior instalado
- Maven 3.6+ instalado

## Como Executar

1. Clone o repositório:
   ```
   git clone https://github.com/2joliveira/logap_api.git
   cd logap_api
   ```

2. Execute a aplicação:
   ```
   mvn spring-boot:run
   ```

A aplicação será iniciada na porta 8080 por padrão.

## Configuração

A aplicação utiliza perfis do Spring:
- **test**: Perfil padrão, utiliza H2 em memória
- **prod**: Para produção (configure no `application-prod.properties`)

As configurações estão em `src/main/resources/application.properties`.

## Banco de Dados

O banco de dados H2 é inicializado com dados de exemplo via `data.sql`. As tabelas incluem:
- `veiculos`: Informações dos veículos
- `viagens`: Registros de viagens
- `manutencoes`: Registros de manutenções (gerenciado via JPA)

## Endpoints da API

### Dashboard
- **GET** `/maintenance/`
- Retorna métricas como quilometragem total, volume por categoria, manutenções agendadas, ranking de uso e projeção financeira.


## Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/logap/logap_api/
│   │   ├── LogapApiApplication.java
│   │   ├── controllers/
│   │   │   └── MaintenanceController.java
│   │   ├── dto/
│   │   │   └── MaintenanceRequest.java
│   │   ├── models/
│   │   │   └── Maintenance.java
│   │   └── repository/
│   │       └── MaintenanceRepository.java
│   └── resources/
│       ├── application.properties
│       ├── application-test.properties
│       └── data.sql
└── test/
    └── java/com/logap/logap_api/
        └── LogapApiApplicationTests.java
```

## Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## Licença

Este projeto está sob a licença [MIT](LICENSE).
