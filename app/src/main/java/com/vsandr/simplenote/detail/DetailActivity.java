package com.vsandr.simplenote.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.vsandr.simplenote.R;
import com.vsandr.simplenote.main.MainActivity;
import com.vsandr.simplenote.model.Note;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements DetailView {

    DetailPresenter detailPresenter;
    private int mNote;

    @BindView(R.id.text_note)TextView mTextViewNote;
    @BindView(R.id.text_date)TextView mTextViewDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        mNote = Objects.requireNonNull(getIntent().getExtras()).getInt("id", 0);

        detailPresenter = new DetailPresenter(DetailActivity.this, this);
        detailPresenter.getNote(mNote);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu_detail_delete:
                detailPresenter.deleteNote(mNote);
                break;
        }
        return true;
    }

    @Override
    public void displayNote(Note note) {
        mTextViewNote.setText(note.getNote());
        mTextViewDate.setText(note.getTimestamp());
    }

    @Override
    public void deleteNote() {
        Toast.makeText(getApplicationContext(), R.string.toast_note_delete, Toast.LENGTH_LONG).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 1);
    }


}
