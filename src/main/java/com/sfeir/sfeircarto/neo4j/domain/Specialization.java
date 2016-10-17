package com.sfeir.sfeircarto.neo4j.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(of = {"parentSkill", "childSkill" }) 

@RelationshipEntity(type="HAS_SPECIALIZATION_IN")
public class Specialization {

	@Setter(value = AccessLevel.PRIVATE)
    @GraphId
    private Long id;

	@StartNode
    private Skill parentSkill;
    @EndNode
    private Skill childSkill;

}
