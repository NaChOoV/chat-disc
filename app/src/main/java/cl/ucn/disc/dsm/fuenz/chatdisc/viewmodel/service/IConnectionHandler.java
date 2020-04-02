/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.service;

import android.util.Pair;

import kotlin.Triple;

public interface IConnectionHandler {

    /**
     * This method will send a request for a new registration to the server.
     *
     * @param email have to be unique.
     * @param username identification between all users
     * @param password secret code to access to the account
     * @return the {@link int} of a status code .
     */
    int registerHandler(final String email,
                        final String username,
                        final String password);

    /**
     * This method will send a request for a authentication to the server
     *
     * @param email have to be unique.
     * @param password secret code to access to the account
     * @return the {@link Pair} with the status code and the username.
     */
    Triple<Integer,Integer,String> loginHandler(final String email,
                                                final String password);


}
