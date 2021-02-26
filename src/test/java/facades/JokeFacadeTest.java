package facades;

import entities.Joke;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;
import entities.RenameMe;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class JokeFacadeTest {

    private static EntityManagerFactory emf;
    private static JokeFacade facade;
    private static Joke joke1, joke2;

    public JokeFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = JokeFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        joke1 = new Joke("JokeHaha", "Joke om svenskere", "Svenskeren gik in på en bar");
        joke2 = new Joke("JokeØvØv", "Jokes om danskere", "Danskeren gik in på en bar");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.persist(joke1);
            em.persist(joke2);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void testAFacadeMethod() {
        assertEquals(2, facade.getJokeCount(), "Expects two rows in the database");
    }
    @Test
    public void testingGetJokeByID(){
        assertEquals(facade.getJokeByID(joke1.getId()).getJoke(), joke1.getJoke(), "Expects the joke from the db to be the same as the one from the object above");
    }
    @Test
    public void testingGetAllJokes(){
        assertEquals(facade.getAllJokes().size(), 2, "Expects the joke amount of jokes in db to be 2");
    }
    @Test
    public void testingGetRandomJoke(){
        Assertions.assertTrue(facade.getRandomJoke()!=null, "testing that something comes out, since testing on randoms is hard");
    }

}
