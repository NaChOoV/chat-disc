package cl.ucn.disc.dsm.fuenz.chatdisc.room.dao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;

@Dao
public interface MessageDao {
    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Message message);

    @Query("DELETE FROM conversation")
    void deleteAll();

    @Query("SELECT * from conversation ORDER BY time ASC")
    LiveData<List<Message>> getAllMessageOrderByDate();
}
