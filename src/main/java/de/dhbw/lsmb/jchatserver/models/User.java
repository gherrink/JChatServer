/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver.models;

import com.sun.istack.internal.NotNull;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(length = 50, name = "user_name")
    @NotNull
    private String user;
    
    @Column(length = 64)
    @NotNull
    private String password;
    
    @Column(length = 80)
    @NotNull
    private String mail;
    
    public User(String user, String mail, String password)
    {
        this.user = user;
        this.mail = mail;
        this.password = password;
    }
    
    /**
     * @return the id
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return the user
     */
    public String getUser()
    {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user)
    {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public static String hashPassword(String password)
    {
        MessageDigest messageDigest;
        try
        {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            return new String(messageDigest.digest());
        }
        catch(NoSuchAlgorithmException ex)
        {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password;
    }

    /**
     * @return the mail
     */
    public String getMail()
    {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail)
    {
        this.mail = mail;
    }
    
}
