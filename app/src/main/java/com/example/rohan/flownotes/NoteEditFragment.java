package com.example.rohan.flownotes;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoteEditFragment extends Fragment {


    public NoteEditFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentLayout = inflater.inflate(R.layout.fragment_note_edit, container, false);

        EditText message = (EditText) fragmentLayout.findViewById(R.id.editNoteMessage);
        ImageButton noteCatbButton = (ImageButton) fragmentLayout.findViewById(R.id.editNoteButton);

        Intent intent = getActivity().getIntent();
        message.setText(intent.getExtras().getString(NoteActivity.NOTE_MESSAGE_EXTRA));

        Note.Category noteCat = (Note.Category) intent.getSerializableExtra(NoteActivity.NOTE_CATEGORY_EXTRA);
        noteCatbButton.setImageResource(Note.categoryToDrawable(noteCat));

        // Inflate the layout for this fragment
        return fragmentLayout;
    }

}
