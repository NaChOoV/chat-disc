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

    @Query("DELETE FROM conversation_table")
    void deleteAll();

    @Query("SELECT * from conversation_table " +
            "WHERE (user_one_fk = :idOne AND user_two_fk = :idTwo) OR (user_one_fk = :idTwo AND user_two_fk = :idOne) " +
            "ORDER BY time ASC")
    LiveData<List<Message>> getChatMessageOrderByDate(int idOne,int idTwo);
}
