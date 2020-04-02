/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Alvaro Castillo Calabacero
 *  contact alvarolucascc96@gmail.com
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository.service;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model.Conversation;
import java.util.List;

public interface ConversationService {
  List<Conversation> getTopHeadLines(final int pageSize);
  List<Conversation> getConversations(final int pageSize);

  int registerUser(final String email,final String username, final String password);


}
