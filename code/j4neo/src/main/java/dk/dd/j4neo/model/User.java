package dk.dd.j4neo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@Data
@NodeEntity
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnoreProperties("followers")
    @Relationship(type = "FOLLOWS", direction = INCOMING)
    private List<User> followers;

    @JsonIgnoreProperties("following")
    @Relationship(type = "FOLLOWS", direction = OUTGOING)
    private List<User> following = new ArrayList<>();


    public String getName() {
        return name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public User() { }

    public User(String name, int released, String tagline)
    {
        this.name = name;
    }
}
