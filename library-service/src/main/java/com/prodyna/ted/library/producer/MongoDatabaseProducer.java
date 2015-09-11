/**
 * 
 */
package com.prodyna.ted.library.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@ApplicationScoped
public class MongoDatabaseProducer {

	private static final String LIBRARY_DATABASE = "library";
	
	@Inject
	private MongoClient mongoClient;
	
	@Produces
	public MongoDatabase produceMongoDatabase(InjectionPoint injectionPoint) {
		return mongoClient.getDatabase(LIBRARY_DATABASE);
	}
}
