package cl.ucn.disc.dsm.fuenz.chatdisc.database.dao;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.database.entity.Message;

public interface MessageDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Message message);

    @Query("DELETE FROM conversation_reply")
    void deleteAll();

    @Query("SELECT * from conversation_reply ORDER BY time ASC")
    MutableLiveData<List<Message>> getAllMessageOrderByDate();
}
