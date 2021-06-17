package dk.dd.j4neo.repository;

import dk.dd.j4neo.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface UserRepository extends Neo4jRepository<User, Long>
{
     User getUserByName(String name);

    @Query("MATCH (am:User)<-[ai:ACTED_IN]-(p:Person)-[d:DIRECTED]->(dm:User) return p, collect(ai), collect(d), collect(am), collect(dm)")
    List<User> getPersonsWhoActAndDirect();
}
