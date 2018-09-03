package com.vsandr.simplenote.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.vsandr.simplenote.R;
import com.vsandr.simplenote.adapter.NotesAdapter;
import com.vsandr.simplenote.add.AddActivity;
import com.vsandr.simplenote.model.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    MainPresenter mainPresenter;
    private NotesAdapter mAdapter;
    @BindView(R.id.recycler_notes)RecyclerView mRecyclerViewNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerViewNotes.setLayoutManager(mLayoutManager);

        mainPresenter = new MainPresenter(this);
        mainPresenter.getNotes(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(MainActivity.this, AddActivity.class));

            }
        });
    }

    @Override
    public void displayNotes(List<Note> notes) {
        mAdapter = new NotesAdapter(notes);
        mRecyclerViewNotes.setAdapter(mAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Toast.makeText(MainActivity.this, "onActivityResult", Toast.LENGTH_LONG).show();
        super.onActivityResult(requestCode, resultCode, data);
    }


}
