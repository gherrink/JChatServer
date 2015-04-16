/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver;

import de.dhbw.lsmb.jchatserver.models.UserRegister;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class RegisterResource extends ServerResource
{
    @Put
    public UserRegister sendMessage(UserRegister register) {
        return register;
    }
}
