# Admin Workflow

Backend includes the ability to dynamically create Assistants, Rag Connections, and LLM Connections

## Content Retriever(RAG) Connction

### Weaviate Example

```json
{
  "baseRetrieverRequest": {
    "contentRetrieverType": "weaviate",
    "textKey": "source",
    "metadata": ["source","page_number", "title"], 
    "index": "my_custom_index",
    "scheme": "http",
    "host": "my-weaviate-instance.svc:8080",
    "apiKey" : "ABCDE12345"
  },
  "embeddingType": "noimc",
  "name": "Example Rag Connection",
  "description": "Example of a rag connection"
}
```
