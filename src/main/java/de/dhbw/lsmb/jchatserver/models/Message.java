/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver.models;

import java.util.Date;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class Message
{
    private String message;
    private String sender;
    private Date date;
    
    public Message(String message, String sender)
    {
        this(message, sender, new Date());
    }
    
    public Message(String message, String sender, Date date)
    {
        this.message = message;
        this.sender = sender;
        this.date = date;
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
    public String getSender()
    {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender)
    {
        this.sender = sender;
    }

    /**
     * @return the date
     */
    public Date getDate()
    {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date)
    {
        this.date = date;
    }
    
}
