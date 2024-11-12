package com.redhat.composer.model.mongo.contentretrieverentites;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;

/**
 * Neo4J Entity.
 */
@SuppressWarnings("all")
@BsonDiscriminator("neo4j")
public class Neo4jEntity extends BaseRetrieverConnectionEntity {

}
