package com.example.rohan.flownotes;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.w3c.dom.Node;

import java.util.ArrayList;

import static com.example.rohan.flownotes.NoteActivity.FragmentToLaunch.EDIT;
import static com.example.rohan.flownotes.NoteActivity.FragmentToLaunch.VIEW;

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

        registerForContextMenu(getListView());
    }

    @Override
    public void onListItemClick(ListView  l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        launchNoteDetailActivity(NoteActivity.FragmentToLaunch.VIEW, position);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.long_press_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int rowPosition = info.position;

        // returns id of whatever menu item selected
        switch(item.getItemId()){
            case R.id.edit:
                launchNoteDetailActivity(NoteActivity.FragmentToLaunch.EDIT, rowPosition);
                Log.d("Menu Clicks", "We pressed the button");
                return true;
        }

        return super.onContextItemSelected(item);
    }

    private void launchNoteDetailActivity(NoteActivity.FragmentToLaunch ftl, int position) {

        Note note = (Note) getListAdapter().getItem(position);
        Intent intent = new Intent(getActivity(), NoteDetailActivity.class);


        intent.putExtra(NoteActivity.NOTE_MESSAGE_EXTRA, note.getMessage());
        intent.putExtra(NoteActivity.NOTE_CATEGORY_EXTRA, note.getCategory());
        intent.putExtra(NoteActivity.NOTE_ID_EXTRA, note.getId());

        switch (ftl) {
            case VIEW:
                intent.putExtra(NoteActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA, NoteActivity.FragmentToLaunch.VIEW);
                break;
            case EDIT:
                intent.putExtra(NoteActivity.NOTE_FRAGMENT_TO_LOAD_EXTRA, NoteActivity.FragmentToLaunch.EDIT);
                break;
        }



    }
