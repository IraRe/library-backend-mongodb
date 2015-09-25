/**
 * 
 */
package com.prodyna.ted.library.relationship;

import org.neo4j.graphdb.RelationshipType;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public enum LibraryRelationshipType implements RelationshipType {
	
	LENT_BY,
	WRITTEN_BY,
	IS_IN

}
