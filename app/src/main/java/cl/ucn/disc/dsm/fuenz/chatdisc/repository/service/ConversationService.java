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

  List<Conversation> getConversations(final int pageSize);

  List<Conversation> getTopHeadLines(final int pageSize);
}
