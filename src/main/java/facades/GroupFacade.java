package facades;

//import dtos.RenameMeDTO;
import dtos.GroupMemberDTO;
import entities.GroupMember;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class GroupFacade {

    private static GroupFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private GroupFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static GroupFacade getGroupFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GroupFacade();
        }   
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public GroupMemberDTO create(GroupMemberDTO gm){
        GroupMember gme = new GroupMember(gm.getName(), gm.getStudentID(), gm.getFavoriteShow()); // Hvorfor er der et "kopi-objekt" her af parameterets object? Hvorfor ikke bare bruge objektet?
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(gme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new GroupMemberDTO(gme);
    }
//    public RenameMeDTO getById(long id){
//        EntityManager em = emf.createEntityManager();
//        return new RenameMeDTO(em.find(RenameMe.class, id));
//    }
    
    //TODO Remove/Change this before use
    public long getGroupCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long gropmemCount = (long)em.createQuery("SELECT COUNT(r) FROM GroupMember r").getSingleResult();
            return gropmemCount;
        }finally{  
            em.close();
        }
        
    }
    
    public List<GroupMemberDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<GroupMember> query = em.createQuery("SELECT g FROM GroupMember g", GroupMember.class);
        List<GroupMember> rms = query.getResultList();
        return GroupMemberDTO.getDtos(rms);
    }

}
