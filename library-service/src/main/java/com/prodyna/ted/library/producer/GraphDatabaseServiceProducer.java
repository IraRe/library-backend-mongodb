package com.prodyna.ted.library.producer;

import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

/**
 * 
 * @author sschubert
 *
 */
@Singleton
@Startup
public class GraphDatabaseServiceProducer {
	
	private static final String TARGET_NEO4J_DB = "D:/TED/TED9/Programms/neo4j-enterprise-2.2.5";
	private static final GraphDatabaseService GRAPH_DATABASE_SERVICE = new GraphDatabaseFactory().newEmbeddedDatabase( TARGET_NEO4J_DB );
	
	@Produces
	public GraphDatabaseService produce(){
		return GRAPH_DATABASE_SERVICE;
	}
	
	@PreDestroy
	public void shutDown(){
		GRAPH_DATABASE_SERVICE.shutdown();
	}

}
