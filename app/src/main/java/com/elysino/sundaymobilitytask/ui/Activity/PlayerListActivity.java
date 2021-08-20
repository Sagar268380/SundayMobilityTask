package com.elysino.sundaymobilitytask.ui.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elysino.sundaymobilitytask.R;
import com.elysino.sundaymobilitytask.contract.PlayerContract;
import com.elysino.sundaymobilitytask.model.Player;
import com.elysino.sundaymobilitytask.presenter.PlayerListPresenter;
import com.elysino.sundaymobilitytask.ui.Adapter.PlayerAdapter1;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerListActivity extends AppCompatActivity implements PlayerContract.View {

    PlayerAdapter1 playerAdapter;
    RecyclerView recyclerView;
    PlayerContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        setUpUiElements();
        Intent intent = getIntent();
        presenter = new PlayerListPresenter(this);
        presenter.start(intent);
    }

    private void setUpUiElements() {
        recyclerView = findViewById(R.id.recycle_view);
        playerAdapter = new PlayerAdapter1(PlayerListActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(playerAdapter);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void addItems(ArrayList<Player> arrayList) {
        playerAdapter.addItems(arrayList);
    }

    @Override
    public Boolean isActive() {
        return !isFinishing();
    }

    @Override
    public void sortByFirstName(ArrayList<Player> arrayList) {
        Collections.sort(arrayList, (o1, o2) -> {
            String s1 = o1.getName();
            String s2 = o2.getName();
            return s1.compareToIgnoreCase(s2);
        });
        playerAdapter.addItems(arrayList);
    }

    @Override
    public void sortByLastName(ArrayList<Player> arrayList) {
        Collections.sort(arrayList, (o1, o2) -> {
            String surName = o1.getName().substring(o1.getName().lastIndexOf(" ") + 1);
            String surName1 = o2.getName().substring(o2.getName().lastIndexOf(" ") + 1);
            return surName.compareToIgnoreCase(surName1);
        });
        playerAdapter.addItems(arrayList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1: {
                presenter.sortByFirstName();
            }
            return true;
            case R.id.item2: {
                presenter.sortByLastName();
            }
            return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}