package com.db2.productsurvey.beans;

import com.db2.productsurvey.entities.SimpleUser;
import com.db2.productsurvey.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

@Stateless(name = "UserServiceBean")
public class UserServiceBean {
    @PersistenceContext(unitName = "ProductSurvey")
    private EntityManager em;

    public UserServiceBean() {
    }

    public void initPlutoUser() {
        SimpleUser user=new SimpleUser();
        user.setUsername("pluto");
        user.setPassword("pluto");
        user.setEmail("pip@pip.it");
        user.setBlocked(false);
        em.persist(user);
    }

    public User checkCredentials(String username, String password) {
        //initPlutoUser();
        try {
            return em.createNamedQuery("User.checkCredentials", User.class).setParameter("username", username).setParameter("password", password).getSingleResult();
        }
        catch(NoResultException e) {
            return null;
        }
    }

    public User updateUser(User user) {
        return em.merge(user);
    }
}