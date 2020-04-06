/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.service;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.ConversationService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.MessageReceivedApiService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model.Conversation;

import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.service.ConnectionHandler;
import java.util.List;
import kotlin.Triple;
import org.junit.jupiter.api.Assertions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Test;


public class ConversationServiceTest {


  /**
   * Test {@link ConversationService#getConversations (int)} with NewsAPI.org
   */
  @Test
  public void testGetConversations() {


  }

  /**
   *
   */
  @Test
  public void TestRegister(){
    //Register perfect
    String user ="usrtest";
    String password = "pwtest";
    String email = "emailtest@gmail.com";
    ConnectionHandler connectionHandler = new ConnectionHandler();
    final ConversationService connectionService = new MessageReceivedApiService();
    int code =connectionHandler.registerHandler(email,user,password);
    Assertions.assertEquals(0,code);

    //Register with same email, and diferent user
    user ="userTest";
    code =connectionHandler.registerHandler(email,user,password);
    Assertions.assertEquals(1,code);

    //Register with same user, diferent email
    user ="usrtest";
    email ="emailtest2@gmail.com";
    code =connectionHandler.registerHandler(email,user,password);
    Assertions.assertEquals(2,code);

  }

  @Test
  public void TestLogin(){
    //correct login
    String password = "yo";
    String email = "alvarolucascc96@gmail.com";
    ConnectionHandler connectionHandler = new ConnectionHandler();
    final ConversationService connectionService = new MessageReceivedApiService();
    Triple<Integer,Integer,String> triple =connectionHandler.loginHandler(email,password);
    int code = triple.getFirst();
    Assertions.assertEquals(0,code);

    //invalid credentials
    password = "yo1";
    triple =connectionHandler.loginHandler(email,password);
    code = triple.getFirst();
    Assertions.assertEquals(1,code);
  }
}


