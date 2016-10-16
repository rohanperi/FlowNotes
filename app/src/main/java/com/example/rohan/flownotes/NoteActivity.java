package com.example.rohan.flownotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class NoteActivity extends AppCompatActivity {

    public static final String NOTE_ID_EXTRA = "com.example.rohan.flownotes.Identifier";
    public static final String NOTE_MESSAGE_EXTRA = "com.example.rohan.flownotes.Message";
    public static final String NOTE_CATEGORY_EXTRA = "com.example.rohan.flownotes.Category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // This is testing my branch 1.
    }

}