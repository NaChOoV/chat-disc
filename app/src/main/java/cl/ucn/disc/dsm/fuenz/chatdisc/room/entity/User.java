/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.room.entity;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {
    /*
   The unique user id
    */
    @PrimaryKey
    private final int user_id;
    /*
    The name of the user
     */
    private final String username;
    /*
    the email of the user
     */
    private final String email;
    /*
    The password of the user
     */
    private final String pwd;

    public User(int user_id, String username, String email, String pwd) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.pwd = pwd;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPwd() {
        return pwd;
    }
}
