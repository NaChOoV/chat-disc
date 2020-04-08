package cl.ucn.disc.dsm.fuenz.chatdisc.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cl.ucn.disc.dsm.fuenz.chatdisc.room.dao.MessageDao;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.dao.UserDao;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.Message;
import cl.ucn.disc.dsm.fuenz.chatdisc.room.entity.User;

@Database(entities = {Message.class}, version = 2, exportSchema = false)
public abstract class MessageRoomDatabase extends RoomDatabase {

    public abstract MessageDao messageDao();

    private static volatile MessageRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static MessageRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (MessageRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MessageRoomDatabase.class, "message_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(messageRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback messageRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                //FIXME: Eliminar estos metodos.
                long time = System.currentTimeMillis();
                Date date =new Date(time);

                Calendar c = Calendar.getInstance();

                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");

                MessageDao dao = INSTANCE.messageDao();
                dao.deleteAll();




            });

        }
    };

}
