package com.example.rohan.flownotes;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NoteDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_detail);

        createAndAddFragment();
    }

    private void createAndAddFragment() {

        Intent intent = getIntent();
        NoteActivity.FragmentToLaunch fragmentToLaunch = (NoteActivity.FragmentToLaunch) intent.getSerializableExtra(NoteActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch(fragmentToLaunch){
            case EDIT:
                NoteEditFragment noteEditFragment = new NoteEditFragment();
                setTitle("Edit Note");
                fragmentTransaction.add(R.id.note_container, noteEditFragment, "NOTE_EDIT_FRAGMENT");
                break;
            case VIEW:
                NoteViewFragment noteViewFragment = new NoteViewFragment();
                setTitle("View Note");
                fragmentTransaction.add(R.id.note_container, noteViewFragment, "NOTE_VIEW_FRAGMENT");
                break;
        }


        fragmentTransaction.commit();
    }
}