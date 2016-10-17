package com.sfeir.sfeircarto.neo4j.repository;

import com.sfeir.sfeircarto.neo4j.domain.Knowledge;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface KnowledgeRepository extends GraphRepository<Knowledge> {

}
