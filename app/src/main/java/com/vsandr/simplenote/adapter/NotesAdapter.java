package com.vsandr.simplenote.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vsandr.simplenote.R;
import com.vsandr.simplenote.model.Note;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {

    private List<Note> notesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_note)TextView mTextViewNote;
        @BindView(R.id.text_date)TextView mTextViewDate;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public NotesAdapter(List<Note> notesList) {
        this.notesList = notesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.mTextViewNote.setText(note.getNote());
        holder.mTextViewDate.setText(note.getTimestamp());
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }


}
