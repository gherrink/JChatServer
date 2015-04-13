/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver.models;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class UserRegister
{
    
    private String user;
    private String password;
    private String passwordRepaed;

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

    /**
     * @return the passwordRepaed
     */
    public String getPasswordRepaed()
    {
        return passwordRepaed;
    }

    /**
     * @param passwordRepaed the passwordRepaed to set
     */
    public void setPasswordRepaed(String passwordRepaed)
    {
        this.passwordRepaed = passwordRepaed;
    }
    
}
