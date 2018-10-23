/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import pojos.Player;

/**
 *
 * @author micha
 */
public class DB_Access {

    private EntityManagerFactory emf;
    private EntityManager em;
    
    public static DB_Access theInstance = null;

    public static DB_Access getInstance() {
        if (theInstance == null) {
            theInstance = new DB_Access();
        }
        return theInstance;
    }

    private DB_Access() {

    }

    public void connect() {
        emf = Persistence.createEntityManagerFactory("CheckMatesPU");
        em = emf.createEntityManager();
    }

    public void disconnect() {
        em.close();
        emf.close();
    }

    public boolean insertUser(String username, String password1, String password2) {
        try {
            if (password1.equals(password2)) {
                TypedQuery<Player> users = em.createNamedQuery("Player.findAll", Player.class);
                List<Player> usersList = users.getResultList();
                for (Player user : usersList) {
                    if(user.getUsername().equals(username))
                    {
                        return false;
                    }
                }
                Player user = new Player(username, password1, 1000L);
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public Player getUser(String username, String password) {
        TypedQuery<Player> user = em.createNamedQuery("Player.getPlayer", Player.class);
        user.setParameter("username", username);
        user.setParameter("password", password);
        List<Player> userList = user.getResultList();
        if(userList != null)
        {
            return userList.get(0);
        }
        return null;
    }
}
