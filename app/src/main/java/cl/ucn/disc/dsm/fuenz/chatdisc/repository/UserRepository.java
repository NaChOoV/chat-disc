/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.UserRoomDatabase;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.dao.UserDao;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;

public class UserRepository {

    /*
    DAO of the user database
     */
    private UserDao userDao;
    /*
    The LiveData of users from the database
     */
    private LiveData<List<User>> allUser;

    public UserRepository(Application application){
        UserRoomDatabase db = UserRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        allUser = userDao.getAllUserOrderByAsc();
    }

    /*
    Return the LiveData
     */
    public LiveData<List<User>> getAllUser(){
        return allUser;
    }

}
