/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api;

import android.os.Build.VERSION_CODES;
import androidx.annotation.RequiresApi;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.ConversationService;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.ApiResult;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.LoginResult;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.MessageReceived;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.api.jsonadapter.RegisterResult;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.model.Conversation;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.service.Transfomer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import kotlin.Triple;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

public class MessageReceivedApiService implements ConversationService {

  /**
   * The logger.
   */
  private static final Logger log = LoggerFactory.getLogger(MessageReceivedApiService.class);

  /**
   * The API.
   */
  private final Api api;

  /**
   * The Constructor.
   */

  public MessageReceivedApiService() {


    // Logging with slf4j
    final HttpLoggingInterceptor loggingInterceptor =
        new HttpLoggingInterceptor(log:: debug).setLevel(Level.BODY);

    // Web Client
    final OkHttpClient httpClient = new Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .callTimeout(10, TimeUnit.SECONDS)
        .addNetworkInterceptor(loggingInterceptor)
        .build();

    this.api = new Retrofit.Builder()
        // The main URL
        .baseUrl(Api.BASE_URL)
        // JSON to POJO
        .addConverterFactory(GsonConverterFactory.create())
        // Validate the interface
        .validateEagerly(true)
        // The client
        .client(httpClient)
        // Build the Retrofit ..
        .build()
        // .. get the NewsApi.
        .create(Api.class);
  }

  /**
   * Get the Conversations from the Call.
   *
   * @param theCall to use.
   * @return the {@link List} of {@link Conversation}.
   */
  @RequiresApi(api = VERSION_CODES.N)
  private static List<Conversation> getConversationsFromCall(final Call<ApiResult> theCall) {

    try {

      // Get the result from the call
      final Response<ApiResult> response = theCall.execute();


      // UnSuccessful !
      if (!response.isSuccessful()) {

        // Error!
        throw new ApiException(
            "Can't get the AResult, code: " + response.code(),
            new HttpException(response)
        );
      }
      final ApiResult theResult = response.body();

      // No body
      if (theResult == null) {
        throw new ApiException("ApiResult was null");
      }

      // No articles
      if (theResult.conversations == null) {
        throw new ApiException("Conversations in ApiResult was null");
      }


      final Transfomer transfomer = new Transfomer();
      List<Conversation> conversationList = new ArrayList<Conversation>();
      for (MessageReceived message: theResult.conversations){
         Conversation conversation= transfomer.transform(message);
         conversationList.add(conversation);
      }

      return conversationList;

    } catch (final IOException ex) {
      throw new ApiException("Can't get the ApiResult", ex);
    }

  }

  /**
   * Get the status code from the server,
   *
   * @param theCall to use.
   * @return the {@link int} with the status code of the request.
   */
  @RequiresApi(api = VERSION_CODES.N)
  private static int getRegisterStatusFromCall(final Call<RegisterResult> theCall) {

    try {

      // Get the result from the call
      final Response<RegisterResult> response = theCall.execute();


      // UnSuccessful !
      if (!response.isSuccessful()) {

        // Error!
        throw new ApiException(
                "Can't get the A Result, code: " + response.code(),
                new HttpException(response)
        );
      }

      final RegisterResult theResult = response.body();


      // No body
      if (theResult == null) {
        throw new ApiException("RegisterResult was null");
      }

      // No code
      if (theResult.code == null) {
        throw new ApiException("Status code in RegisterResult was null");
      }

      return Integer.parseInt(theResult.code);

    } catch (final IOException ex) {

      return 3;

    }

  }

  /**
   * Send the a request for login confirmation to the server.
   *
   * @param theCall to use.
   * @return the {@link Triple} with a status code, userid and the username.
   */
  @RequiresApi(api = VERSION_CODES.N)
  private static Triple<Integer,Integer,String> getLoginConformationFromCall(final Call<LoginResult> theCall) {

    try {

      // Get the result from the call
      final Response<LoginResult> response = theCall.execute();


      // UnSuccessful !
      if (!response.isSuccessful()) {

        // Error!
        throw new ApiException(
                "Can't get the A Result, code: " + response.code(),
                new HttpException(response)
        );
      }

      final LoginResult theResult = response.body();

      // No body
      if (theResult == null) {
        throw new ApiException("RegisterResult was null");
      }

      // No code
      if (theResult.code == null) {
        throw new ApiException("Status code in LoginResult was null");
      }

      // No username
      if (theResult.username == null) {
        throw new ApiException("Status code in LoginResult was null");
      }

      // No userId
      if (theResult.userId == null) {
        throw new ApiException("User id in LoginResult was null");
      }

      return new Triple<Integer,Integer,String>(
              Integer.parseInt(theResult.code),
              Integer.parseInt(theResult.userId),
              theResult.username);

    } catch (final IOException ex) {

        return new Triple<Integer,Integer,String>(
                2,
                null,
                null);

    }

  }


  @Override
  public List<Conversation> getConversations(int pageSize) {
    // the Call
    final Call<ApiResult> theCall = this.api.getEverything(pageSize);


    // Process the Call.
    return getConversationsFromCall(theCall);
  }

  @Override
  public List<Conversation> getTopHeadLines(int pageSize) {
    return null;
  }

  @Override
  public int registerUser(String email, String username, String password) {

    final Call<RegisterResult> theCall = this.api.registerUser(email,username,password);

    return getRegisterStatusFromCall(theCall);
  }

  @Override
  public Triple<Integer, Integer, String> loginUser(String email, String password) {

    final Call<LoginResult> theCall = this.api.loginUser(email,password);

    return getLoginConformationFromCall(theCall);
  }

  /**
   * The ApiException.
   */
  public static final class ApiException extends RuntimeException {

    public ApiException(final String message) {
      super(message);
    }

    public ApiException(final String message, final Throwable cause) {
      super(message, cause);
    }

  }


}
