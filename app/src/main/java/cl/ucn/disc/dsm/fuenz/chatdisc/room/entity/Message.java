/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.threeten.bp.ZonedDateTime;


@Entity(tableName = "conversation_reply")
public class Message {

    /*
    The unique conversation id
     */
    @PrimaryKey
    private final int cr_id;
    /*
    The message info
     */
    @ColumnInfo(name = "reply")
    private final String text;
    /*
    The id of the users who send the message
     */
    private final int user_one;
    /*
    The id of the user who recive the message
     */
    private final int user_two;
    /*
    When de message was send
     */
    private final ZonedDateTime time;
    /*
    GPS Latitude
     */
    private final float latitude;
    /*
    GPS Longitude
     */
    private final float longitude;
    /*
    Status of the conversation
     */
    private int status;
    /*
    ID of the general conversation between two users
     */
    private final int c_id_fk;

    public Message(int cr_id, String text, int user_one,int user_two, ZonedDateTime time, float latitude, float longitude, int c_id_fk) {
        this.cr_id = cr_id;
        this.text = text;
        this.user_one = user_one;
        this.user_two = user_two;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.c_id_fk = c_id_fk;
    }


    public int getCr_id() {
        return cr_id;
    }

    public String getText() {
        return text;
    }

    public int getUser_one() {
        return user_one;
    }

    public int getUser_two() {
        return user_two;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public int getStatus() {
        return status;
    }

    public int getC_id_fk() {
        return c_id_fk;
    }
}
