package com.vsandr.simplenote.main;

import android.content.Context;

import com.vsandr.simplenote.database.DatabaseHelper;
import com.vsandr.simplenote.model.Note;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void getNotes(Context context){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        List<Note> notesList = new ArrayList<>(databaseHelper.getAllNotes());
        mainView.displayNotes(notesList);
    }
}
