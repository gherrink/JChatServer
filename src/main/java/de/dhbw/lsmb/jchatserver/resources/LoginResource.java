/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver.resources;

import de.dhbw.lsmb.jchatserver.db.EntityManagement;
import de.dhbw.lsmb.jchatserver.db.models.User;
import de.dhbw.lsmb.jchatserver.json.models.JsonUser;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.restlet.data.CookieSetting;
import org.restlet.data.Status;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class LoginResource extends ServerResource
{
    public static final String SAFTYCOOKIEID = "saftycookie";
    
    private static final String SELECT = "FROM User u WHERE u.mail = :mail AND u.password = :password";
    
    @Put
    public String login(JsonUser user) {
        String pw = User.hashPassword(user.getPassword(), user.getMail());
        
        EntityManager em = EntityManagement.createEntityManager();
        Query query = em.createQuery(SELECT);
        query.setParameter("mail", user.getMail());
        query.setParameter("password", pw);
        
        if(query.getResultList().isEmpty()){
            em.close();
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            return "Mail or password is incorrect.";
        }
        
        CookieSetting cs = new CookieSetting(0, SAFTYCOOKIEID, pw);
        this.getResponse().getCookieSettings().add(cs);
        
        setStatus(Status.SUCCESS_OK);
        return "logged in";
    }
}
