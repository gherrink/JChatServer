/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver.json.models;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class JsonMessage
{
    private String date;
    private String message;
    private String user;
    
    public JsonMessage() {
        this(null, "Default Message", "User");
    }
    
    public JsonMessage(String message, String user)
    {
        this(null, message, user);
    }
    
    public JsonMessage(String date, String message, String user)
    {
        this.date = date;
        this.message = message;
        this.user = user;
    }
    
    /**
     * @return the message
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message)
    {
        this.message = message;
    }

    /**
     * @return the sender
     */
    public String getUser()
    {
        return user;
    }

    /**
     * @param user the sender to set
     */
    public void setUser(String user)
    {
        this.user = user;
    }

    /**
     * @return the date
     */
    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
}
