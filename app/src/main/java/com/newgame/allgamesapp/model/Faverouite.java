package com.newgame.allgamesapp.model;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "faverouite_table")
public class Faverouite {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String game_name;
    private String game_image;
    private String game_id;

    public Faverouite(String game_name, String game_image, String game_id) {
        this.game_name = game_name;
        this.game_image = game_image;
        this.game_id = game_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getGame_name() {
        return game_name;
    }

    public String getGame_image() {
        return game_image;
    }

    public String getGame_id() {
        return game_id;
    }
}
