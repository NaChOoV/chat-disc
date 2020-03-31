/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.MessageRoomDatabase;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.dao.MessageDao;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;

public class MessageRepository {

    private MessageDao messageDao;

    private MutableLiveData<List<Message>> allMessages;

    public MessageRepository(Application application){
        MessageRoomDatabase db = MessageRoomDatabase.getDatabase(application);

        messageDao = db.messageDao;
        allMessages = messageDao.getAllMessageOrderByDate();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    public MutableLiveData<List<Message>> getAllMessages() {
        return allMessages;
    }

    public void insert(Message message){
        MessageRoomDatabase.databaseWriteExecutor.execute(()->{
            messageDao.insert(message);
        });
    }
}
