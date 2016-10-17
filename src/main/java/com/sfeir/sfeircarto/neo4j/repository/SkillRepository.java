package com.sfeir.sfeircarto.neo4j.repository;

import com.sfeir.sfeircarto.neo4j.domain.Skill;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface SkillRepository extends GraphRepository<Skill> {

	/**
	 * Représente le noeud racine de notre arborescence de compétences
	 */
	public final static String ROOT_SKILL_NODE = "ROOT_SKILL_NODE";
		
	/**
	 * Trouver une Compétence par son nom, ou renvoit null.
	 * En théorie, l'attribut Name est unique pour les compétences donc on ne renvoit pas un Iterable.
	 * @param keyword
	 * @return
	 */
	Skill findByName(String keyword);

	/**
	 * Retourne toutes les compétences connues d'une Persone
	 * @param personName Nom de la personne
	 * @return
	 */
	@Query("MATCH (n:Person)-[:KNOWS]->(skills) WHERE n.email={0} RETURN skills")
    Iterable<Skill> findByPersonEmail(String personEmail);
	
	/**
	 * Retourne toutes les compétences connues d'une Persone
	 * @param id Id de la Personne
	 * @return
	 */
	@Query("MATCH (n:Person)-[:KNOWS]->(skills) WHERE ID(n)={0} RETURN skills")
    Iterable<Skill> findByPersonId(Long id);
	
}
