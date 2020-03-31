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
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;
import cl.ucn.disc.dsm.fuenz.chatdisc.repository.MessageRepository;

public class MessageViewModel extends AndroidViewModel {

    private MessageRepository messageRepository;

    private MutableLiveData<List<Message>> allMessage;

    public MessageViewModel(@NonNull Application application) {
        super(application);

        messageRepository = new MessageRepository(application);

        allMessage = messageRepository.getAllMessages();
    }

    MutableLiveData<List<Message>> getAllMessage(){
        return allMessage;
    }

    public void insert(Message message) {messageRepository.insert(message);}
}
