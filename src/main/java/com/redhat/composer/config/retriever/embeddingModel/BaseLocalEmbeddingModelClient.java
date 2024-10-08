package com.redhat.composer.config.retriever.embeddingModel;

import java.util.concurrent.Executor;

import dev.langchain4j.model.embedding.onnx.AbstractInProcessEmbeddingModel;
import dev.langchain4j.model.embedding.onnx.OnnxBertBiEncoder;


public class BaseLocalEmbeddingModelClient extends AbstractInProcessEmbeddingModel {

  // Add explicit constructor
  public BaseLocalEmbeddingModelClient(Executor executor) {
    super(executor);
  }

  // Can be overridden by subclasses
  static String MODEL_NAME = "model.onnx";
  static String TOKENIZER_NAME = "tokenizer.json";

  

  @Override
  protected OnnxBertBiEncoder model() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'model'");
  }
  

  
}