package com.example.room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity1 extends AppCompatActivity {
     private EditText edt;
     public static final String NOTE_ADDED ="new_note";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_note);

        edt=findViewById(R.id.edt);
        Button button=findViewById(R.id.btnS);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if(TextUtils.isEmpty(edt.getText())){
                    setResult(RESULT_CANCELED,resultIntent);
                }else{
                    String note =edt.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED,note);
                    setResult(RESULT_OK,resultIntent);
                }
                finish();

            }
        });

    }
}

