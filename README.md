# Quarkus LLM Routing Service

Quarkus Service that allows for the routing to different RAG sources and LLMs

## Architecture

![](.assets/Routing%20Service.drawio.png)

### Chat Bot Message Architecture

The `assistant/chat/streaming` will be the main use endpoint. In which we specify the a message to our chat and the name of an assistant.

```json
{
  "message": "User Message",
  "assistantName": "assistant_name"
}
```

Available Assistants by default:
- default_ocp
- default_rhel
- default_rho_2025_faq
- default_ansible
- default_rhoai


The `/chatbot/chat/stream` allows for connections to be specified directly through the UI 

```json
  {
  message: "User Message",
  context: "Message history",
  retriverRequest: {
          index: "weveIndex",
          scheme: "weveSchem",
          host: "weavHost.com",
          apiKey: "xxx",
          }
  modelRequest {
          modelType: "servingRuntime",
          apiKey: "xxxxx",
          modelName: "mistral-instruct",
        }
  }
```

## Assistant Workflow

The main workflow will be through assistants. These will be created by administrators and once created can be accessed by users.

```json
  {
    message: "User Message",
    context: "Message history",
    assistantName: "Name of Assistant",
    assistantId: "Id of Assistant" // Ignored in name is provided
  }
```


> Important: This is assuming access to a default weaviate db with the correct indexes populated.

Test Curl Command:
```json
curl -X 'POST'   'http://localhost:8080/assistant/chat/streaming' -H 'Content-Type: application/json'   -d '{
  "message": "What is this product?",
  "assistantName": "default_rhoai"
}' -N

```

## Install Locally

To install locally run:

```sh
mvn clean install
mvn quarkus:dev
```

Need to login to Openshift using `oc login` and run the following command to port forward the vector DB

```sh
oc port-forward service/weaviate-vector-db  8086:8080 50051:50051
```

## Test Locally

The following curl command should return a streaming output answering based on the default Rag/LLM settings (set in the properties file)

`curl -X POST -H "Content-Type: application/json" -d '{"message":"What is a route?"}' http://localhost:8080/chatbot/chat/streaming -N`

> Note: There are endpoint for testing each of the specific components

## Embedding Model

IMPORTANT: The embedding modes is to large to check into our repo. So you need to download from the following link and put it in `resources/embedding/nomic`.

https://drive.google.com/drive/folders/1jZe0cEw8p_E-fghd6IFPjwiabDNAhtp7?usp=drive_link

We need to figure out a better way to handel this in the future (or put this on github)

## Code Standards

### CheckStyle Linting

Linting is does using checkstyle and a slightly modified version of the [Google Java Style guide](https://google.github.io/styleguide/javaguide.html).

Run `mvn checkstyle:check -Dcheckstyle.config.location=checkstyle.xml`

### OWasp Security Scanning

The [OWASP Dependency-Check Plugin](https://owasp.org/www-project-dependency-check/) can be run using the following command:

```sh
mvn validate -P security-scanner
```
