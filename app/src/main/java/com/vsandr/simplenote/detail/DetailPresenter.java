package com.vsandr.simplenote.detail;

import android.content.Context;

import com.vsandr.simplenote.database.DatabaseHelper;

public class DetailPresenter {

    private Context context;
    private DetailView detailView;

    public DetailPresenter(Context context, DetailView detailView) {
        this.context = context;
        this.detailView = detailView;
    }

    public void getNote(int id){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        detailView.displayNote(databaseHelper.getNote(id));
    }

    public void deleteNote(int id){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        databaseHelper.deleteNote(databaseHelper.getNote(id));
        detailView.deleteNote();
    }
}
