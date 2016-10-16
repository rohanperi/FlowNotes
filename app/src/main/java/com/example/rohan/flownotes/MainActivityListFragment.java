package com.example.rohan.flownotes;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    private ArrayList<Note> notes;
    private NoteAdapter noteAdapter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        /*
        String[] values = new String[]{"Android", "IPhone", "Windows", "Blackberry", "Ubuntu", "Lord Gaben"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);

        */

        notes =  new ArrayList<Note>();
        notes.add(new Note("This is the body of the message", Note.Category.LOW));
        notes.add(new Note("This is the body of the message", Note.Category.HIGH));
        notes.add(new Note("This is the body of the message", Note.Category.MEDIUM));
        notes.add(new Note("This is the body of the message", Note.Category.LOW));
        notes.add(new Note("This is the body of the message", Note.Category.LOW));
        notes.add(new Note("This is the body of the message", Note.Category.HIGH));
        notes.add(new Note("This is the body of the message", Note.Category.LOW));
        notes.add(new Note("This is the body of the message", Note.Category.MEDIUM));

        noteAdapter = new NoteAdapter(getActivity(), notes);

        setListAdapter(noteAdapter);

    }

    @Override
    public void onListItemClick(ListView  l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

}
