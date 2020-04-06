/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.MessageRepository;

public class MessageViewModel extends AndroidViewModel {

    private MessageRepository messageRepository;
    private int idOne;
    private int idTwo;

    private LiveData<List<Message>> allMessage;

    public MessageViewModel(@NonNull Application application,int idOne,int idTwo) {
        super(application);
        this.idOne = idOne;
        this.idTwo = idTwo;
        messageRepository = new MessageRepository(application,this.idOne, this.idTwo);

        allMessage = messageRepository.getAllMessages();
    }

    public LiveData<List<Message>> getAllMessage(){
        return allMessage;
    }

    public void insert(Message message) {messageRepository.insert(message);}
}
