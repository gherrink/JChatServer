/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver;

import de.dhbw.lsmb.jchatserver.db.EntityManagement;
import de.dhbw.lsmb.jchatserver.db.models.User;
import de.dhbw.lsmb.jchatserver.json.models.JsonUserRegister;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.restlet.data.Status;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class RegisterResource extends ServerResource
{
    private static final String SELECT_USER = "FROM User u WHERE u.user = :user";
    private static final String SELECT_MAIL = "FROM User u WHERE u.mail = :mail";
    
    @Put
    public String sendMessage(JsonUserRegister register) {
        if(! register.getPassword().equals(register.getPasswordRepaed())) {
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            return "Passworeds are not equal.";
        }
        
        EntityManager em = EntityManagement.createEntityManager();
        Query query = em.createQuery(SELECT_USER);
        query.setParameter("user", register.getUser());
        if(! query.getResultList().isEmpty()){
            em.close();
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            return "User already exists.";
        }
        
        query = em.createQuery(SELECT_MAIL);
        query.setParameter("mail", register.getMail());
        if(! query.getResultList().isEmpty()){
            em.close();
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            return "Mail already exists.";
        }
        
        User newUser = new User(register.getUser(), register.getMail(), User.hashPassword(register.getPassword()));
        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();
        em.close();
        
        setStatus(Status.SUCCESS_OK);
        return "registered";
    }
}
