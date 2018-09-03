package com.vsandr.simplenote.main;

import com.vsandr.simplenote.model.Note;

import java.util.List;

public interface MainView {
    void displayNotes(List<Note> notes);
}
