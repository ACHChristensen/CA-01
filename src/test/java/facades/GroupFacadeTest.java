
package facades;

import dtos.GroupMemberDTO;
import entities.GroupMember;
import entities.RenameMe;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;


public class GroupFacadeTest {
    
    private static EntityManagerFactory emf;
    private static GroupFacade facade;
    
    public GroupFacadeTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = GroupFacade.getGroupFacade(emf);
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("GroupMember.deleteAllRows").executeUpdate();
            em.persist(new GroupMember("Peter", "kea-pp300", "Nyhederne"));
            em.persist(new GroupMember("Betina", "cbs-bb401", "My little pony"));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @AfterEach
    public void tearDown() {
        
    }


    @Test
    public void testCreate() {
        GroupMember gm = new GroupMember("Kurt", "kea-kh809", "Teletubbies");
        GroupMemberDTO gmdto = new GroupMemberDTO(gm);
        GroupMemberDTO result = facade.create(gmdto);
    
        assertEquals(3, facade.getAll().size());
    }

    @Test
    public void testGetGroupCount() {
        long expected = 2;
        long members = facade.getGroupCount();
        assertEquals(expected, members);
    }

    @Test
    public void testGetAll() {
        int expResult = 2;
        List<GroupMemberDTO> result = facade.getAll();
        assertEquals(expResult, result.size());
    }

    
}
