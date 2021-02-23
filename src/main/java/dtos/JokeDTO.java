/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Joke;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class JokeDTO {
    private long id;
    private String joke;
    private String type;
    private String jokeName;

    public static List<JokeDTO> getDtos(List<Joke> rms){
        List<JokeDTO> rmdtos = new ArrayList();
        rms.forEach(rm->rmdtos.add(new JokeDTO(rm)));
        return rmdtos;
    }
    public static JokeDTO getDto(Joke rms){
        return new JokeDTO(rms);
    }


    public JokeDTO(Joke rm) {
        this.id= rm.getId();
        this.joke = rm.getJoke();
        this.type = rm.getType();
        this.jokeName = rm.getJokeName();
    }

    public long getId() {
        return id;
    }

    public void setJokeName(String jokeName) {
        this.jokeName = jokeName;
    }

    public String getJokeName() {
        return jokeName;
    }

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

    @Override
    public String toString() {
        return "JokeDTO{" +
                "id=" + id +
                ", joke='" + joke + '\'' +
                ", type='" + type + '\'' +
                ", jokeName='" + jokeName + '\'' +
                '}';
    }
}
