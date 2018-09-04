package com.vsandr.simplenote.detail;

import com.vsandr.simplenote.model.Note;

public interface DetailView {
    void displayNote(Note note);
    void deleteNote();
}
