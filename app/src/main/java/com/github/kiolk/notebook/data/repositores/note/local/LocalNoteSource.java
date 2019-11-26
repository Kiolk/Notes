package com.github.kiolk.notebook.data.repositores.note.local;

import android.content.Context;

import com.github.kiolk.notebook.data.DBHelper;
import com.github.kiolk.notebook.data.models.Note;
import com.github.kiolk.notebook.data.repositores.note.NoteDataSource;

import java.util.List;

public class LocalNoteSource implements NoteDataSource {


    private DBHelper helper;

    public LocalNoteSource(Context context) {
        helper = new DBHelper(context);
    }

    @Override
    public void insertNote(Note note) {
        //TODO
    }

    @Override
    public void updateNote(Note note) {
        //TODO
    }

    @Override
    public void deleteNote(long id) {
        //TODO
    }

    @Override
    public List<Note> getAllNotes() {
        //TODO
        return null;
    }
}
