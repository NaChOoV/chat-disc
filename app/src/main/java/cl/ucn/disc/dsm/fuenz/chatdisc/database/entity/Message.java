package cl.ucn.disc.dsm.fuenz.chatdisc.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.threeten.bp.ZonedDateTime;


@Entity(tableName = "conversation_reply")
public class Message {

    @PrimaryKey
    private int cr_id;

    @ColumnInfo(name = "reply")
    private String text;

    private int user_id_fk;

    private ZonedDateTime time;

    private float latitude;

    private float longitude;

    private int status;

    private int c_id_fk;



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
