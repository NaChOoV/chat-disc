/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.service;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.ConversationService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.MessageReceivedApiService;

public class ConnectionHandler implements IConnectionHandler{


    @Override
    public int registerHandler(String email, String username, String password){
        // The connection service
        final ConversationService connectionService = new MessageReceivedApiService();

        return connectionService.registerUser(email,username,password);
    }

    @Override
    public String loginHandler(String email, String password) {
        return null;
    }
}
