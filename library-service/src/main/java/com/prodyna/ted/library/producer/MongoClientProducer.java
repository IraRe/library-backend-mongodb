package com.prodyna.ted.library.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import com.mongodb.MongoClient;


/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@ApplicationScoped
public class MongoClientProducer {
	private static final int PORT = 27017;
	private static final String HOST = "127.0.0.1";
	
	@Produces
	public MongoClient produceMongoClient(InjectionPoint injectionPoint) {
		return new MongoClient(HOST, PORT);
	}
}
