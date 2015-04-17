/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver.resources;

import de.dhbw.lsmb.jchatserver.json.models.JsonMessage;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */

public class MessageResource extends ServerResource {

    @Put
    public JsonMessage sendMessage(JsonMessage message) {
        return message;
    }

}
