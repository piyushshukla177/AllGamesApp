package com.newgame.allgamesapp.model;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

public class FaverouiteDao {
    @Dao
    public interface NoteDao {
        @Insert
        void insert(Faverouite note);

        @Update
        void update(Faverouite note);

        @Delete
        void delete(Faverouite note);

        @Query("DELETE FROM faverouite_table")
        void deleteAllFaverouite();

        @Query("SELECT * FROM faverouite_table")
        List<Faverouite> getAllFavertouite();
    }
}
