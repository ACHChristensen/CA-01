package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Joke.deleteAllRows", query = "DELETE from Joke")
public class Joke implements Serializable {
    String joke;
    String type;
    String jokeName;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Joke() {
    }

    public Joke(String joke, String type, String jokeName) {
        this.joke = joke;
        this.type = type;
        this.jokeName = jokeName;
    }
// TODO, delete this class, or rename to an Entity class that makes sense for what you are about to do
    // Delete EVERYTHING below if you decide to use this class, it's dummy data used for the initial demo

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJokeName() {
        return jokeName;
    }

    public void setJokeName(String jokeName) {
        this.jokeName = jokeName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Joke{" +
                "joke='" + joke + '\'' +
                ", type='" + type + '\'' +
                ", jokeName='" + jokeName + '\'' +
                ", id=" + id +
                '}';
    }
}