# 📢 EAD-Notification Microservice

Microsserviço responsável pelo gerenciamento e envio de **notificações** em uma plataforma **EAD (Ensino a Distância)**, desenvolvido seguindo os princípios de **arquitetura de microsserviços**, **desacoplamento**, **mensageria** e **boas práticas de design**.

---

## 🧩 Visão Geral

O **EAD-Notification** é um microsserviço dedicado exclusivamente ao domínio de notificações, permitindo o envio e processamento assíncrono de eventos provenientes de outros serviços do ecossistema EAD.

Ele atua como:
- **Consumer de mensagens** via RabbitMQ
- **API REST** para comunicação síncrona
- **Cliente de Service Registry** para descoberta de serviços

---

## 🏗️ Arquitetura

Principais componentes utilizados:

- **Arquitetura de Microsserviços**
- **Mensageria com RabbitMQ**
- **API REST**
- **Service Registry (Service Discovery)**
- **Tratamento centralizado de exceções**
- **Padrão em camadas**

---

## 🔄 Comunicação

### 📬 Mensageria (RabbitMQ)
- Consumo de eventos assíncronos
- Processamento desacoplado de notificações
- Maior resiliência e escalabilidade

### 🌐 API REST
- Endpoints REST para integração síncrona
- Retorno padronizado de respostas HTTP
- Validação de dados de entrada

---

## ⚙️ Configuração Centralizada (Config Server)

O microsserviço **EAD-Notification** utiliza configurações externas e centralizadas fornecidas pelo **EAD-Config-Server**, garantindo maior flexibilidade, padronização e facilidade de manutenção no ambiente de microsserviços.

### 🔧 Benefícios do uso do Config Server
- Centralização das propriedades de configuração
- Alteração de configurações sem necessidade de rebuild
- Padronização entre os microsserviços
- Separação clara entre código e configuração
- Facilidade de gerenciamento por ambiente (dev, hml, prod)

### 📂 Tipos de configurações gerenciadas
As seguintes configurações são obtidas dinamicamente via **EAD-Config-Server**:
- Conexão com RabbitMQ
- Configurações de filas e exchanges
- Propriedades da API REST
- Configurações do Service Registry
- Parâmetros de timeout e retry
- Outras propriedades sensíveis ou específicas por ambiente

### 🔄 Integração
No momento da inicialização, o **EAD-Notification** se conecta ao **EAD-Config-Server** para carregar suas configurações, garantindo que o microsserviço esteja sempre alinhado às definições centralizadas do ecossistema.

> Este modelo permite maior escalabilidade e controle sobre a arquitetura distribuída, reduzindo riscos e custos operacionais.


## 🧱 Estrutura do Projeto

Organização baseada em boas práticas de separação de responsabilidades:

├── controller/

│ |── API REST

├── consumers/

│ ├── RabbitMQ Consumers

├── dtos/

│ ├── Data Transfer Objects

├── enums/

│ ├── Enumerações do domínio

├── exceptions/

│ ├── Tratamento global de exceções

├── models/

│ ├── Entidades do domínio

├── repositories/

│ ├── Acesso a dados

├── services/

│ ├── Regras de negócio

├── configs/

│ ├── Configurações (RabbitMQ, etc.)


---

## ⚠️ Tratamento de Exceções

O microsserviço possui um **tratamento centralizado de exceções**, garantindo:

- Respostas HTTP padronizadas
- Mensagens claras para o cliente
- Facilidade de manutenção e evolução
- Melhor experiência para consumidores da API

Exemplos de retornos:

- `404 Not Found`
- 
---

## 🗂️ Padrões Utilizados

- **DTO Pattern** – Separação entre API e domínio
- **Service Layer** – Centralização da lógica de negócio
- **Repository Pattern** – Abstração do acesso a dados
- **Enumeração de estados e tipos**
- **Mensageria assíncrona**
- **Service Discovery**

---

## 🧭 Service Registry

Este microsserviço é **cliente de um Service Registry**, permitindo:

- Descoberta dinâmica de serviços
- Balanceamento de carga
- Maior escalabilidade e flexibilidade na arquitetura

---

## 🚀 Benefícios

- Alta escalabilidade
- Baixo acoplamento
- Processamento assíncrono eficiente
- Organização clara do código
- Facilidade de integração com outros microsserviços

---

## Microservices da Arquitetura

Para o funcionamento completo da arquitetura em ambiente local, todos os microservices do ecossistema devem estar em execução utilizando o profile ativo `dev`.

Os microservices que compõem a arquitetura são:

- [Authuser Microservice](https://github.com/Igorgcf/EAD-Authuser)
- [Course Microservice](https://github.com/Igorgcf/EAD-Course)
- [API Gateway](https://github.com/Igorgcf/EAD-API-Gateway)
- [Service Discovery (Eureka Server)](https://github.com/Igorgcf/EAD-Service-Registry)
- [Config Server](https://github.com/Igorgcf/EAD-Config-Server)
- Execute [Notification Microservice](https://github.com/Igorgcf/EAD-Notification)
  ou
  [Notification-Hex Microservice](https://github.com/Igorgcf/EAD-Notification-Hexagonal)

> ℹ️ Certifique-se de executar todos os serviços com o profile `dev` ativo para garantir a comunicação correta entre os microservices durante o desenvolvimento local.

---

## 📌 Observações

Este microsserviço faz parte de um ecossistema maior e foi projetado para funcionar de forma independente, porém integrada aos demais serviços da plataforma EAD.

---

![image](https://qnax.sh/blog/wp-content/uploads/2024/04/spring-framework-1024x576.png)
