/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author micha
 */
@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String password;
    private int mmr;

    public User() {
    }

    public User(Long id, String username, String password, int mmr) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mmr = mmr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMmr() {
        return mmr;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", mmr=" + mmr + '}';
    }
}
