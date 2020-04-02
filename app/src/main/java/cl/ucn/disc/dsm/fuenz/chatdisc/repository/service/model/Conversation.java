/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Alvaro Castillo Calabacero
 *  contact alvarolucascc96@gmail.com
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model;

import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;

public class Conversation {

  public static final ZoneId ZONE_ID = ZoneId.of("-3");
  public int id;
  public String reply;
  public int user_one_fk;
  public int user_two_fk;
  public ZonedDateTime time;
  public float latitude,longitude;
  public  String createdAt;
  public  String updatedAt;

  public Conversation(int id, String reply, int user_one_fk, int user_two_fk, ZonedDateTime createdAt, float latitude, float longitude, String createdAt1,
      String updatedAt) {
    this.id=id;
    this.reply=reply;
    this.user_one_fk=user_one_fk;
    this.user_two_fk=user_two_fk;
    this.time=createdAt;
    this.latitude=latitude;
    this.longitude=longitude;
    this.createdAt=createdAt1;
    this.updatedAt=updatedAt;
  }
}
