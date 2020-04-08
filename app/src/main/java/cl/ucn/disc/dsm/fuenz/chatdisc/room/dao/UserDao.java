/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.room.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;

@Dao
public interface UserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(User user);

    @Query("DELETE FROM user_table")
    void deleteAll();

    //TODO: agregar filtro (WHERE NOT IN) para que el usuario logeado no este incluido
    @Query("SELECT * from user_table ORDER BY username ASC")
    LiveData<List<User>> getAllUserOrderByAsc();
}
