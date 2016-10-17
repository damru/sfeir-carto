package com.sfeir.sfeircarto.neo4j.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.*;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(of = { "person", "skill" }) 

@RelationshipEntity(type="KNOWS")
public class Knowledge {

	@Setter(value = AccessLevel.PRIVATE)
    @GraphId
    private Long id;

	@Property
    private Integer level;
    @StartNode
    private Person person;
    @EndNode
    private Skill skill;
    
}
