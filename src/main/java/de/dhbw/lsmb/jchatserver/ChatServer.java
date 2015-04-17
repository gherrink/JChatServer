/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dhbw.lsmb.jchatserver;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author Maurice Busch <busch.maurice@gmx.net>
 */
public class ChatServer extends Application {
    
    public static void main(String[] args) throws Exception {  
        Component component = new Component();  
        component.getServers().add(Protocol.HTTP, 8182);  
        component.getDefaultHost().attach("",  new ChatServer());  
        component.start();  
    }
    
    /**
     * Creates a root Restlet that will receive all incoming calls.
     * @return 
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/history", HistoryResource.class);
        router.attach("/message", MessageResource.class);
        router.attach("/register", RegisterResource.class);

        return router;
    }

}
