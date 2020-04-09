/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.repository.UserRepository;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;

/**
 * Communication between UI and repository
 */
public class UserViewModel extends AndroidViewModel {
    /*
    The repository
     */
    private UserRepository userRepository;
    /*
    The livedata of users
     */
    private LiveData<List<User>> allUser;
    /*
    The constructor
     */
    public UserViewModel (Application application){
        super(application);
        userRepository = new UserRepository(application);
        allUser = userRepository.getAllUser();

    }

    /**
     * get all users from de database
     * @return
     */
    public LiveData<List<User>> getAllUser(){
        return allUser;
    }



}
