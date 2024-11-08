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

### Testing Authentication Locally

Authentication has been implemented in the project, but is disabled by default.  To turn authentication on, set the environment variable `DISABLE_AUTHENTICATION` to `false`.  

Quarkus devservices provides the ability to run a local instance of keycloak with a provided configuration.  The following property has been added to trigger a keycloak container configured from the file at `config/quarkus-realm.json`:
```
quarkus.keycloak.devservices.realm-path=quarkus-realm.json
```
Alternatively, if running in jvm mode a docker container can be created manually.  See https://quarkus.io/guides/security-keycloak-authorization#starting-and-configuring-the-keycloak-server.


When calling endpoints, all calls will now return a 401.  To authenticate, a token is now required.  Retrieve a token from keycloak, as a bearer token.

**NOTE:** keycloak gets a random port, so use `docker ps` to see which port was assigned.

```
export access_token=$(\                                                                                                              curl --insecure -X POST http://localhost:32847/realms/quarkus/protocol/openid-connect/token \
    --user backend-service:secret \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'username=alice&password=alice&grant_type=password' | jq --raw-output '.access_token' \
 )

curl -v --location 'http://localhost:8080/chatbot/chat/streaming' --header 'Content-Type: application/json' -H 'Authorization: Bearer '$access_token --data '  {"message": "How do I reboot a node?"}'
```

## Embedding Model

IMPORTANT: The embedding modes is too large to check into our repo. So you need to download from the following link and put it in `resources/embedding/nomic`.

https://drive.google.com/drive/folders/1jZe0cEw8p_E-fghd6IFPjwiabDNAhtp7?usp=drive_link

We need to figure out a better way to handel this in the future (or put this on github)

## Tech Debt

Figure out better secret management
