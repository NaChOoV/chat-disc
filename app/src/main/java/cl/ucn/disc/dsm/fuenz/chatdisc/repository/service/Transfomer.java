/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Alvaro Castillo Calabacero
 *  contact alvarolucascc96@gmail.com
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository.service;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.MessageReceived;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.MessageReceivedApiService.ApiException;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model.Conversation;
import javax.xml.transform.Transformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeParseException;

public class Transfomer {

  /**
   * The logger.
   */
  private static final Logger log = LoggerFactory.getLogger(Transformer.class);


  public Conversation transform(final MessageReceived message) {

    // Nullity message
    if (message == null) {
      throw new ApiException("message was null");
    }

    //Nullity time
    if (message.time == null){
      throw new ApiException("Id for message was 0");
    }

    // Nullity repy
    if (message.reply == null) {
      throw new ApiException("reply was null");
    }


    if (message.id==0){
      throw new ApiException("Id for message was 0");
    }

    if (message.user_one_fk == 0 || message.user_two_fk ==0) {
      throw new ApiException("Id for one user was 0");
    }

    if (message.latitude == 0 || message.longitude == 0){
      throw new ApiException("longitude or latitude was 0");
    }

    // The date.
    final ZonedDateTime createdAt = parseZonedDateTime(message.createdAt)
        .withZoneSameInstant(Conversation.ZONE_ID);

    // The Noticia.
    return new Conversation(
        message.id,
        message.reply,
        message.user_one_fk,
        message.user_two_fk,
        createdAt,
        message.latitude,
        message.longitude,
        message.createdAt,
        message.updatedAt
    );


  }

  private static ZonedDateTime parseZonedDateTime(final String fecha) {

    // Na' que hacer si la fecha no existe
    if (fecha == null) {
      throw new ApiException("Can't parse null fecha");
    }

    try {
      // Tratar de convertir la fecha ..
      return ZonedDateTime.parse(fecha);
    } catch (DateTimeParseException ex) {

      // Mensaje de debug
      log.error("Can't parse date: ->{}<-. Error: ", fecha, ex);

      // Anido la DateTimeParseException en una NoticiaTransformerException.
      throw new ApiException("Can't parse date: " + fecha, ex);
    }
  }

}
