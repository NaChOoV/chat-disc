/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.service;

import android.util.Pair;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.ConversationService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.MessageReceivedApiService;
import kotlin.Triple;

public class ConnectionHandler implements IConnectionHandler{


    @Override
    public int registerHandler(final String email,final String username,final String password){
        // The connection service
        final ConversationService connectionService = new MessageReceivedApiService();

        return connectionService.registerUser(email,username,password);
    }

    @Override
    public Triple<Integer,Integer,String> loginHandler(final String email,final String password) {

        final ConversationService connectionService = new MessageReceivedApiService();

        return connectionService.loginUser(email,password);
    }
}
