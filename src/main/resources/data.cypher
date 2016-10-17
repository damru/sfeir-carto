CREATE (Michel:Person {name:'Michel', email:'michel@sfeir.com'})
CREATE (Langages:Skill {name: 'Langages'})
CREATE (Cpp:Skill {name: 'C++'})
CREATE (Java:Skill {name: 'Java'})
CREATE (Spring:Skill {name: 'Spring'})
CREATE (SpringMVC:Skill {name: 'Spring MVC'})
CREATE (SpringBoot:Skill {name: 'Spring Boot'})
CREATE (Java8:Skill {name: 'Java 8'})
CREATE (Industrialisation:Skill {name: 'Industrialisation'})
CREATE (Jenkins:Skill {name: 'Jenkins'})
CREATE (Root:Skill {name: 'ROOT_SKILL_NODE'})
CREATE 
   (Michel)-[:KNOWS {level:3}]->(Java),
   (Michel)-[:KNOWS {level:2}]->(Spring),
   (Michel)-[:KNOWS {level:2}]->(Jenkins),
   (Langages)-[:HAS_SPECIALIZATION_IN]->(Java),
   (Langages)-[:HAS_SPECIALIZATION_IN]->(Cpp),
   (Java)-[:HAS_SPECIALIZATION_IN]->(Spring),
   (Spring)-[:HAS_SPECIALIZATION_IN]->(SpringMVC),
   (Spring)-[:HAS_SPECIALIZATION_IN]->(SpringBoot),
   (Java)-[:HAS_SPECIALIZATION_IN]->(Java8),
   (Industrialisation)-[:HAS_SPECIALIZATION_IN]->(Jenkins),
   (Root)-[:HAS_SPECIALIZATION_IN]->(Langages),
   (Root)-[:HAS_SPECIALIZATION_IN]->(Industrialisation)
   