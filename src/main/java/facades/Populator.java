
package facades;

import dtos.GroupMemberDTO;
import entities.GroupMember;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;


public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        GroupFacade gf = GroupFacade.getGroupFacade(emf);
        gf.create(new GroupMemberDTO(new GroupMember("Mari", "cph-mh823", "DeadWood")));
        gf.create(new GroupMemberDTO(new GroupMember("Cathrine", "cph-ac221", "Arrow")));
        gf.create(new GroupMemberDTO(new GroupMember("Nikolaj", "cph-nt105", "Bojack Horseman")));
      
    }
    
    public static void main(String[] args) {
        populate();
    }
}
