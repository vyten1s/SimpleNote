package com.vsandr.simplenote.add;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.vsandr.simplenote.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity implements AddView {

    AddPresenter addPresenter;
    @BindView(R.id.edit_note)EditText mEditTextNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        addPresenter = new AddPresenter(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mEditTextNote.getText().length()!=0 ){
                    addPresenter.saveNote(AddActivity.this, mEditTextNote.getText().toString());
                }
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onNoteSaved() {
        Toast.makeText(getApplicationContext(), R.string.toast_note_add, Toast.LENGTH_LONG).show();
        AddActivity.this.finish();
    }


}
