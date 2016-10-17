package com.sfeir.sfeircarto.neo4j.repository;

import com.sfeir.sfeircarto.neo4j.domain.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.List;

public interface PersonRepository extends GraphRepository<Person> {

	Iterable<Person> findByName(String keyword);
	
	/**
	 * Retourne la personne désignée par l'email, ou null.
	 * L'attribut Email étant, en théorie, unique, on renvoit directement la Personne et non un Iterable.
	 * @param keyword
	 * @return
	 */
	Person findByEmail(String keyword);

	/**
	 * Return all Person from database.
	 * @return a List of Person
	 */
	List<Person> findAll();

}
