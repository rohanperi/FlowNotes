package com.example.rohan.flownotes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abhishek on 10/16/16.
 */

public class NoteAdapter extends ArrayAdapter<Note> {

    public NoteAdapter(Context context, ArrayList<Note> notes) {

        super(context, 0, notes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Get the data item for this position
        Note note = getItem(position);

        //create a new viewholder
        RecyclerView.ViewHolder viewHolder;

        // checks if an existing view is being reused, otherwise inflate a new view from custom row layout
        if (convertView == null) {

            // If we don't have a view that is being used to create one,
            // make sure you create a viewholder along with it ot save our view references too.

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_row, parent, false);

            TextView noteText = (TextView) convertView.findViewById(R.id.listItemNoteBody);
            ImageView noteIcon = (ImageView) convertView.findViewById(R.id.listItemNoteImg);


            // fill each new referenced view with data associated with the note it's referencing
            noteText.setText(note.getMessage());
            noteIcon.setImageResource(note.getAssociatedDrawable());

            // Now that we've modified the view to display appropriate data
            // return it so it will be displayed.
            return convertView;


        }


    }

}



