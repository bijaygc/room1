package com.example.room;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelProvider;

import javax.xml.transform.Result;

public class NoteViewModel extends AndroidViewModel {
    private String TAG = this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteViewModel noteViewModel;

    private NoteRoomDatabase noteDB;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteDao = (NoteDao) NoteRoomDatabase.getDatabase(application);
        noteDB = (NoteRoomDatabase) noteDB.noteDao();

        noteViewModel =  ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(NoteViewModel.class);


    }

    public void insert(Note note) {
        new InsertAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "ViewModel Destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<Note, Void, Void> {
        NoteDao mNoteDao;

        public InsertAsyncTask(NoteDao mNoteDao) {
            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insert(notes[0]);
            return null;
        }

    }
}

