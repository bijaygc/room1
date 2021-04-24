package com.example.room;


import androidx.room.Dao;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

@Dao


@Entity
public interface NoteDao {
    @Insert
    void insert(Note note);

}
