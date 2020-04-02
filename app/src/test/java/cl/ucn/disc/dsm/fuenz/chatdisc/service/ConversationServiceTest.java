/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Alvaro Castillo Calabacero
 *  contact alvarolucascc96@gmail.com
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.service;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.ConversationService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.MessageReceivedApiService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model.Conversation;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConversationServiceTest {
  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(ConversationServiceTest.class);

  /**
   * Test {@link ConversationService#getConversations (int)} with NewsAPI.org
   */
  @Test
  public void testGetNoticiasNewsApi() {

    final int size = 1;

    log.debug("Testing the NewsApiNoticiaService, requesting {} News.", 1);

    // The noticia service
    final ConversationService noticiaService = new MessageReceivedApiService();

    // The List of Noticia.
    final List<Conversation> noticias = noticiaService.getConversations(1);

    Assertions.assertNotNull(noticias);
    Assertions.assertEquals(noticias.size(), size, "Error de tamanio");

    for (final Conversation noticia : noticias) {
      log.debug("Conversation: {}.", noticia);
    }

    log.debug("Done.");

  }
}
