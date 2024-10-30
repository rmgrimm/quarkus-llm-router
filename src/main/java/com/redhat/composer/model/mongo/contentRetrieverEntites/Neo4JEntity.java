package com.redhat.composer.model.mongo.contentRetrieverEntites;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

@BsonDiscriminator("neo4j")
public class Neo4JEntity extends BaseRetrieverConnectionEntity {

}
