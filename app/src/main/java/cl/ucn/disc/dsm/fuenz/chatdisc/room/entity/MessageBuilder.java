/*
 * Copyright (c) 2020. This code is purely educational, the rights of use are
 *  reserved, the owner of the code is Ignacio Fuenzalida Veas
 *  contact ignacio.fuenzalida@alumnos.ucn.cl
 *  Do not use in production.
 */

package cl.ucn.disc.dsm.fuenz.chatdisc.room.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class MessageBuilder {

    private String message;

    private int userOne;

    private int userTwo;

    private String time;

    private float latitude;

    private float longitude;

    public MessageBuilder setMessage(String message){
        this.message = message;
        return this;
    }

    public  MessageBuilder setUserOne(int userOne){
        this.userOne = userOne;
        return this;
    }

    public  MessageBuilder setUserTwo(int userTwo){
        this.userTwo = userTwo;
        return this;
    }

    public  MessageBuilder setTime(String time){
        this.time = time;
        return this;
    }

    public MessageBuilder setLatitude(float latitude){
        this.latitude = latitude;
        return this;
    }

    public  MessageBuilder setLongitude(float longitude){
        this.latitude = longitude;
        return this;
    }

    public Message build(){
        return new Message(message,userOne,userTwo,time,latitude,longitude);
    }

}
