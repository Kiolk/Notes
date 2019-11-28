package com.github.kiolk.notebook.data.repositores.note;

import com.github.kiolk.notebook.data.models.Note;

import java.util.List;

public interface NoteDataSource {

    void insertNote(Note note);

    void updateNote(Note note);

    void deleteNote(long id);

    List<Note> getAllNotes();

    List<Note>getNotes(String search);
}
