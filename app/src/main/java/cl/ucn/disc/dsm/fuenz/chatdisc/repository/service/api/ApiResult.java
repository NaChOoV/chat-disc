/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Alvaro Castillo Calabacero
 *  contact alvarolucascc96@gmail.com
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api;

import java.util.ArrayList;
import java.util.List;

public class ApiResult {

  //public String status;
  //public long totalResults;
  public List<MessageReceived> conversations = new ArrayList<>();

}
