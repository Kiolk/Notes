package com.github.kiolk.notebook.data.repositores.note;

import com.github.kiolk.notebook.data.models.Note;

import java.util.List;

public class DefaultNoteRepository implements NoteRepository {

    private NoteDataSource local;

    public DefaultNoteRepository(NoteDataSource local) {
        this.local = local;
    }

    @Override
    public void insertNote(Note note) {
        local.insertNote(note);
    }

    @Override
    public void updateNote(Note note) {
        local.updateNote(note);
    }

    @Override
    public void deleteNote(long id) {
        local.deleteNote(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return local.getAllNotes();
    }

    @Override
    public List<Note> getNotes(String search) {
        return local.getNotes(search);
    }
}