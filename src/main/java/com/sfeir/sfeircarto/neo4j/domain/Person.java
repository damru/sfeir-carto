package com.sfeir.sfeircarto.neo4j.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(of = "email")

@NodeEntity
public class Person {

	@Setter(value = AccessLevel.PRIVATE)
	@GraphId
    private Long id;

	private String name;

	private String email;

	@Relationship(type = "KNOWS")
	private List<Knowledge> knowledge;

}
