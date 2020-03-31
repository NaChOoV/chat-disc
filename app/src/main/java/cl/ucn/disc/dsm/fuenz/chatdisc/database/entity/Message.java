/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
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
    private final int user_id_fk;
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

    public Message(int cr_id, String text, int user_id_fk, ZonedDateTime time, float latitude, float longitude, int c_id_fk) {
        this.cr_id = cr_id;
        this.text = text;
        this.user_id_fk = user_id_fk;
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

    public int getUser_id_fk() {
        return user_id_fk;
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
