/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver.resources;

import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class LogoutResource extends ServerResource
{   
    @Get
    public String logout() {
        String saftycookie = this.getRequest().getCookies().getFirstValue(LoginResource.SAFTYCOOKIEID);
        
        if(saftycookie == null)
        {
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            return "no user loged in.";
        }
        
        this.getRequest().getCookies().removeFirst(LoginResource.SAFTYCOOKIEID);
        
        setStatus(Status.SUCCESS_OK);
        return "loged out";
    }
}
