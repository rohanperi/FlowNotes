package com.example.rohan.flownotes;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityListFragment extends ListFragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] values = new String[]{"Android", "IPhone", "Windows", "Blackberry", "Ubuntu", "Lord Gaben"};

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, values);

        setListAdapter(adapter);

    }

    @Override
    public void onListItemClick(ListView  l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }

}
