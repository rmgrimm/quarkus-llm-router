package com.redhat.composer.model.enums;

public enum ContentRetrieverType {

    WEAVIATE("weaviate"),
    NEO4J("neo4j");

    private final String type;

    ContentRetrieverType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static ContentRetrieverType fromString(String type) {
        for (ContentRetrieverType retrieverType : ContentRetrieverType.values()) {
            if (retrieverType.getType().equalsIgnoreCase(type)) {
                return retrieverType;
            }
        }
        throw new IllegalArgumentException("No constant with type " + type + " found");
    }
  
}
