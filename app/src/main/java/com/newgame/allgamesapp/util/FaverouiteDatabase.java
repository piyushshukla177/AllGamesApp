package com.newgame.allgamesapp.util;
import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.newgame.allgamesapp.model.Faverouite;
import com.newgame.allgamesapp.model.FaverouiteDao;

@Database(entities = {Faverouite.class}, version = 1)
public abstract class FaverouiteDatabase extends RoomDatabase {
    private static com.newgame.allgamesapp.util.FaverouiteDatabase instance;

    public abstract FaverouiteDao.NoteDao favDao();

    public static synchronized FaverouiteDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    FaverouiteDatabase.class,"faverouite_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
