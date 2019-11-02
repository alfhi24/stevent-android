package com.astronaut.stevent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvEvents;
    private ArrayList<Event> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvEvents = findViewById(R.id.rv_events);
        rvEvents.setHasFixedSize(true);

        list.addAll(DataEvents.getListEvent());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
        ListEventAdapter listEventAdapter = new ListEventAdapter(list);
        rvEvents.setAdapter(listEventAdapter);
    }
}
