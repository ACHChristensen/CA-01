
package facades;

import dtos.CarDTO;
import dtos.GroupMemberDTO;
import entities.Car;
import entities.GroupMember;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

public class Populator {
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    
    
    public static void populateGroupMember(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        GroupFacade gf = GroupFacade.getGroupFacade(emf);
        gf.create(new GroupMemberDTO(new GroupMember("Mari", "cph-mh823", "DeadWood")));
        gf.create(new GroupMemberDTO(new GroupMember("Cathrine", "cph-ac221", "Arrow")));
        gf.create(new GroupMemberDTO(new GroupMember("Nikolaj", "cph-nt105", "Bojack Horseman")));
      
    }
    
    public static void populateCar(){
      EntityManager em = EMF.createEntityManager();
       
       try{
          em.getTransaction().begin();
          em.persist(new Car(1997,"Ford","E350",30000,"Nikolaj Trankjær"));
          em.persist(new Car(1999,"Chevy","Venture",4900,"Jens Ohlendorff"));
          em.persist(new Car(2000,"Chevy","Venture",5000,"John Snow"));
          em.persist(new Car(1996,"Jeep","Grand Cherokee",4799,"Mari Haugen"));
          em.persist(new Car(2005,"Volvo","V70",44744,"Cathrine Christensen"));
          em.persist(new Car(2018,"Tesla","S",65000,"Jonathan Juhl"));
          em.getTransaction().commit();
           
       }finally{
           em.close();
       }
    }
    
    
    
    public static void main(String[] args) {
        populateCar();
    }
}
