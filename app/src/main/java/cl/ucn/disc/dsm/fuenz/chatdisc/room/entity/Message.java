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




@Entity(tableName = "conversation_table")
public class Message {

    /*
    The unique conversation id
     */
    @PrimaryKey
    private final int id;
    /*
    The message info
     */
    @ColumnInfo(name = "reply")
    private final String message;
    /*
    The id of the users who send the message
     */
    @ColumnInfo(name = "user_one_fk")
    private final int userOne;
    /*
    The id of the user who recive the message
     */
    @ColumnInfo(name = "user_two_fk")
    private final int userTwo;
    /*
    When de message was send
     */
    private final String time;
    /*
    GPS Latitude
     */
    private final float latitude;
    /*
    GPS Longitude
     */
    private final float longitude;
    /*
    The constructor
     */
    public Message(int id, String message, int userOne, int userTwo, String time, float latitude, float longitude) {
        this.id = id;
        this.message = message;
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public int getUserOne() {
        return userOne;
    }

    public int getUserTwo() {
        return userTwo;
    }

    public String getTime() {
        return time;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }



}
