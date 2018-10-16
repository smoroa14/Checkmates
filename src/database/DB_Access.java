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

    public boolean insertUser(String username, String password1, String password2) {
        try {
            if (password1.equals(password2)) {
                TypedQuery<User> users = em.createNamedQuery("User.findAll", User.class);
                List<User> usersList = users.getResultList();
                for (User user : usersList) {
                    if(user.getUsername().equals(username))
                    {
                        return false;
                    }
                }
                User user = new User(username, password1, 1000L);
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

    public User getUser(String username, String password) {
        TypedQuery<User> user = em.createNamedQuery("User.getUser", User.class);
        user.setParameter("username", username);
        user.setParameter("password", password);
        List<User> userList = user.getResultList();
        if(userList != null)
        {
            return userList.get(0);
        }
        return null;
    }
    
    public static void main(String[] args) {
        DB_Access access = new DB_Access();
        access.connect();
        System.out.println("Test");
        access.disconnect();
    }
}
