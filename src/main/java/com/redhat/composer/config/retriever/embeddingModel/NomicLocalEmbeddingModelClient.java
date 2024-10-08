package com.redhat.composer.config.retriever.embeddingModel;

import dev.langchain4j.model.embedding.onnx.OnnxBertBiEncoder;
import dev.langchain4j.model.embedding.onnx.PoolingMode;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import jakarta.inject.Singleton;

@Singleton
public class NomicLocalEmbeddingModelClient extends BaseLocalEmbeddingModelClient {

  private final static String MODEL_FOLDER = "embeddings/nomic/";


  private static final OnnxBertBiEncoder MODEL = loadFromJar(
          MODEL_FOLDER + MODEL_NAME,
          MODEL_FOLDER + TOKENIZER_NAME,
            PoolingMode.CLS
    );

    public NomicLocalEmbeddingModelClient() {
        super(Infrastructure.getDefaultExecutor());
    }


    @Override
    protected OnnxBertBiEncoder model() {
        return MODEL;
    }

}
