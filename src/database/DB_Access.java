/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pojos.User;

/**
 *
 * @author micha
 */
public class DB_Access {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void connect() {
        emf = Persistence.createEntityManagerFactory("CheckMatesPU");
        em = emf.createEntityManager();
    }

    public void disconnect() {
        em.close();
        emf.close();
    }

    public void insertUser(String username, String password) {
        User user = new User(username, password, 1000);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }
    
    public boolean checkUser(User u)
    {
        return false;
    }
}
