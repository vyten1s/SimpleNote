package com.vsandr.simplenote.add;

import android.annotation.SuppressLint;
import android.content.Context;

import com.vsandr.simplenote.database.DatabaseHelper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddPresenter {

    private AddView addView;

    public AddPresenter(AddView addView) {
        this.addView = addView;
    }

    public void saveNote(Context context, String note){
        DatabaseHelper databaseHelper = new DatabaseHelper(context);
        databaseHelper.createToDo(note, getDate());
        addView.onNoteSaved();
    }

    private String getDate(){
        Calendar c = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat desiredFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return desiredFormat.format(c.getTime());
    }


}
