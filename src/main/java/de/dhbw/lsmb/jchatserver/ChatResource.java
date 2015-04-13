/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver;

import de.dhbw.lsmb.jchatserver.models.Message;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */

public class ChatResource extends ServerResource {

    @Put
    public String sendMessage(Message message) {
        
        return "message";
    }

}
