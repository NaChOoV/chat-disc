/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Alvaro Castillo Calabacero
 *  contact alvarolucascc96@gmail.com
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.ApiResult;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.LoginResult;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.MessageReceived;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.RegisterResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

  String BASE_URL = "http://127.0.0.1:8000/"; //use php artisan serve , in backend

  public String idUser ="";

  @GET("conversation")
  Call<List<MessageReceived>> getConversations() throws Exception;

  @GET("conversation")
  Call<ApiResult> getEverything(@Query("pageSize") final int pageSize);

  @GET("conversation/"+idUser)
  Call<List<MessageReceived>> getConversationForId();

  @GET("register")
  Call<RegisterResult> registerUser(
          @Query("email") String email,
          @Query("username") String username,
          @Query("password") String password);

  @GET("login")
  Call<LoginResult> loginUser(
          @Query("email") String email,
          @Query("username") String username);


}
