package com.example.room;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private String TAG =this.getClass().getSimpleName();
    public static final int NEW_Requestcode=100;
    public FloatingActionButton floatingActionButton;
    private NoteViewModel noteViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // floatingActionButton=findViewById(R.id.fab);
        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity1.class);
                startActivityForResult(intent, NEW_Requestcode);
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==NEW_Requestcode && resultCode== RESULT_OK){


            final String note_id = UUID.randomUUID().toString();
            Note note = new Note(note_id,data.getStringExtra(Activity1.NOTE_ADDED));
//            noteViewModel.insert(note);

            Toast.makeText(
                    getApplicationContext(),
                    R.string.Saved,
                    Toast.LENGTH_SHORT).show();


        }else{
            Toast.makeText(
                    getApplicationContext(),
                    R.string.not_Saved,
                    Toast.LENGTH_SHORT).show();

        }
    }
}
