/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.MessageRoomDatabase;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.dao.MessageDao;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.MessageBuilder;

public class MessageRepository {

    /*
    The message DAO
     */
    private MessageDao messageDao;

    /*
    The liveData to to hold the List of messages
     */
    private LiveData<List<Message>> allMessages;

    public MessageRepository(Application application,int idOne,int idTwo){
        MessageRoomDatabase db = MessageRoomDatabase.getDatabase(application);

        messageDao = db.messageDao();
        allMessages = messageDao.getChatMessageOrderByDate(idOne,idTwo);

        // TODO: INCIAR PETICION CONSTANTE AL SERVIDOR PARA SER ACTUALIZADA
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public LiveData<List<Message>> getAllMessages() {
        return allMessages;
    }

    public void insert(int idOne, int idTwo, String message){
        long time = System.currentTimeMillis();
        Date date =new Date(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");

        MessageRoomDatabase.databaseWriteExecutor.execute(()->{
            messageDao.insert(
                    new MessageBuilder()
                            .setMessage(message)
                            .setUserOne(idOne)
                            .setUserTwo(idTwo)
                            .setTime(dateFormat.format(date))
                            .setLatitude(123123)
                            .setLongitude(123132)
                            .build()
            );
        });
    }
}
