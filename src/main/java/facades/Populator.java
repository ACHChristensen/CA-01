/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.JokeDTO;
import dtos.RenameMeDTO;
import entities.Joke;
import entities.RenameMe;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        JokeFacade fe = JokeFacade.getFacadeExample(emf);
        fe.create(new JokeDTO(new Joke("First 1", "middle 1", "Last 1")));
        fe.create(new JokeDTO(new Joke("First 2","middle 2", "Last 2")));
        fe.create(new JokeDTO(new Joke("First 3", "middle 3","Last 3")));
        
    }
    
    public static void main(String[] args) {
        populate();
    }
}
