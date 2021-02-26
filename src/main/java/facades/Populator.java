
package facades;
import dtos.JokeDTO;
import dtos.RenameMeDTO;
import entities.Joke;
import entities.RenameMe;

import dtos.GroupMemberDTO;
import entities.GroupMember;

import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;


public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

        JokeFacade fe = JokeFacade.getFacadeExample(emf);
        fe.create(new JokeDTO(new Joke("First 1", "middle 1", "Last 1")));
        fe.create(new JokeDTO(new Joke("First 2","middle 2", "Last 2")));
        fe.create(new JokeDTO(new Joke("First 3", "middle 3","Last 3")));
        

        GroupFacade gf = GroupFacade.getGroupFacade(emf);
        gf.create(new GroupMemberDTO(new GroupMember("Mari", "cph-mh823", "DeadWood")));
        gf.create(new GroupMemberDTO(new GroupMember("Cathrine", "cph-ac221", "Arrow")));
        gf.create(new GroupMemberDTO(new GroupMember("Nikolaj", "cph-nt105", "Bojack Horseman")));
        gf.create(new GroupMemberDTO(new GroupMember("Jonathan", "cph-jj450", "Friends")));
        gf.create(new GroupMemberDTO(new GroupMember("Jens", "cph-jb361", "It's always sunny in Philadelphia")));
      

    }
    
    public static void main(String[] args) {
        populate();
    }
}
