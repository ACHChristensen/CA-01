package facades;

import dtos.JokeDTO;
import dtos.RenameMeDTO;
import entities.Joke;
import entities.RenameMe;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade() {}


    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static JokeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public JokeDTO create(JokeDTO rm){
        Joke rme = new Joke(rm.getJoke(), rm.getType(), rm.getJokeName());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(rme);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new JokeDTO(rme);
    }
    public JokeDTO getJokeByID(long id){
        EntityManager em = emf.createEntityManager();
        return new JokeDTO(em.find(Joke.class, id));
    }

    //TODO Remove/Change this before use
    public long getJokeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long jokeCount = (long)em.createQuery("SELECT COUNT(j) FROM Joke j").getSingleResult();
            return jokeCount;
        }finally{
            em.close();
        }

    }

    public List<JokeDTO> getAllJokes(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<Joke> query = em.createQuery("SELECT j FROM Joke j", Joke.class);
        List<Joke> rms = query.getResultList();
        return JokeDTO.getDtos(rms);
    }

    public JokeDTO getRandomJoke(){

        EntityManager em = emf.createEntityManager();
        TypedQuery<Joke> query = em.createQuery("SELECT j FROM Joke j", Joke.class);
        List<Joke> rms = query.getResultList();
        int randomNum = ThreadLocalRandom.current().nextInt(0, rms.size());
        Joke randomJoke = rms.get(randomNum);
        return JokeDTO.getDto(randomJoke);
    }
/*
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        JokeFacade fe = getFacadeExample(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
    }*/

}
