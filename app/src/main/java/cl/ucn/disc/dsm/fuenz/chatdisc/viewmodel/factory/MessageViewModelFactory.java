/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.factory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel.MessageViewModel;

public class MessageViewModelFactory implements ViewModelProvider.Factory {

    private Application application;
    private int idOne;
    private int idTwo;

    public MessageViewModelFactory(Application application, int idOne, int idTwo) {
        this.application = application;
        this.idOne = idOne;
        this.idTwo = idTwo;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MessageViewModel(application,idOne,idTwo);
    }
}
