package net.wawczak.brian.bloodpressurelog;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    private static final String TAG = "ListDataActivity";
    DatabaseHelper myDataBaseHelper;
    private ListView myListView;
    Context thisContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment_history, container, false);
        View v = inflater.inflate(R.layout.fragment_history, container, false);
        thisContext = container.getContext();

        myListView = v.findViewById(R.id.listView);
        myDataBaseHelper = new DatabaseHelper(thisContext);
        populateListView();

        return v;
    }

    private void populateListView(){
        Log.d(TAG, "populateListView: Displaying data in the ListView,");

        //get the data and append to a list
        Cursor data = myDataBaseHelper.getData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()){
            //get the value from the database in column 1
            //then add it to the ArrayList
            listData.add(data.getString(1));
        }

        //create the list adapter and set the adapter
        ListAdapter adapter = new ArrayAdapter<>(thisContext, android.R.layout.simple_list_item_1, listData);
        myListView.setAdapter(adapter);

    }
}
