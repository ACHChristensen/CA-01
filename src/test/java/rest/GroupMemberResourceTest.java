package rest;

import entities.GroupMember;
import entities.RenameMe;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import static rest.RenameMeResourceTest.startServer;
import utils.EMF_Creator;
//@Disabled

public class GroupMemberResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/ca01/api";
    private static GroupMember gm1, gm2;

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactoryForTest();

        httpServer = startServer();

        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        //System.in.read();

        //Don't forget this, if you called its counterpart in @BeforeAll
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        gm1 = new GroupMember("Peter", "kea-pp300", "Nyhederne");
        gm2 = new GroupMember("Betina", "cbs-bb401", "My little pony");
        try {
            em.getTransaction().begin();
            em.createNamedQuery("GroupMember.deleteAllRows").executeUpdate();
            em.persist(gm1);
            em.persist(gm2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

//     @Test
//    public void testServerIsUp() {
//        System.out.println("Testing is server UP");
//        given().when().get("/groupmember").then().statusCode(200);
//    } SPØRG JON !
    
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        GroupMemberResource instance = new GroupMemberResource();
        String expResult = "";
        String result = instance.getAll();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetRenameMeCount() {
        System.out.println("getRenameMeCount");
        GroupMemberResource instance = new GroupMemberResource();
        String expResult = "";
        String result = instance.getRenameMeCount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

}
