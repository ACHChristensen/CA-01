package facades;

import dtos.CarDTO;
import dtos.RenameMeDTO;
import entities.Car;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CarFacade {

    private static CarFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CarFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CarFacade getCarFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CarDTO create(Car cr) {
        Car car = new Car(cr.getProduced(), cr.getMake(), cr.getModel(), cr.getPrice(), cr.getOwner());
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new CarDTO(car);
    }

    public CarDTO getById(int id) {
        EntityManager em = emf.createEntityManager();
        return new CarDTO(em.find(Car.class, id));
    }

    //TODO Remove/Change this before use
    public int getCarCount() {
        EntityManager em = emf.createEntityManager();
        try {
            int carCount = (int) em.createQuery("SELECT COUNT(c) FROM Car c").getSingleResult();
            return carCount;
        } finally {
            em.close();
        }

    }

    public List<CarDTO> getAll() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Car> query = em.createQuery("SELECT c FROM Car c", Car.class);
        List<Car> cs = query.getResultList();
        return CarDTO.getDtos(cs);
    }

}
