/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.room.dao;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;

public interface UserDao {

    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("DELETE FROM users")
    void deleteAll();

    @Query("SELECT * from users ORDER BY username ASC")
    MutableLiveData<List<User>> getAllUserOrderByAsc();
}
