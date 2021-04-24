package com.example.room;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Student Data")
public class Note {
    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getNote() {
        return this.mNote;
    }

    public Note(String id, String mNote){
        this.id=id;
        this.mNote=mNote;
    }

}
