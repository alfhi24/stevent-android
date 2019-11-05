package com.astronaut.stevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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

        list.addAll(DataEvents.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvEvents.setLayoutManager(new LinearLayoutManager(this));
        ListEventAdapter listEventAdapter = new ListEventAdapter(list);
        rvEvents.setAdapter(listEventAdapter);

        listEventAdapter.setOnItemClickCallback(new ListEventAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Event data) {
                showSelectedEvent(data);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        }
        return true;
    }

    private void showSelectedEvent(Event event) {
        Intent detailEvent = new Intent(MainActivity.this, DetailActivity.class);
        detailEvent.putExtra(DetailActivity.EXTRA_IMAGE, event.getImage());
        detailEvent.putExtra(DetailActivity.EXTRA_NAME, event.getName());
        detailEvent.putExtra(DetailActivity.EXTRA_DATE, event.getDate());
        detailEvent.putExtra(DetailActivity.EXTRA_LOCATION, event.getLocation());
        detailEvent.putExtra(DetailActivity.EXTRA_DETAIL, event.getDetail());
        startActivity(detailEvent);

    }
}
