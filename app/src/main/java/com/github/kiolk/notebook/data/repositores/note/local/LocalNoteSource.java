package com.github.kiolk.notebook.data.repositores.note.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.github.kiolk.notebook.data.DBHelper;
import com.github.kiolk.notebook.data.models.Note;
import com.github.kiolk.notebook.data.repositores.note.NoteDataSource;

import java.util.ArrayList;
import java.util.List;

public class LocalNoteSource implements NoteDataSource {


    private DBHelper helper;

    public LocalNoteSource(Context context) {
        helper = new DBHelper(context);
    }

    @Override
    public void insertNote(Note note) {
        ContentValues cv = new ContentValues();
        cv.put(Note.COLUMN_TITLE, note.getTitle());
        cv.put(Note.COLUMN_TEXT, note.getText());
        helper.getReadableDatabase().insert(Note.TABLE_NAME, null, cv);
    }

    @Override
    public void updateNote(Note note) {
        ContentValues cv = new ContentValues();
        cv.put(Note.COLUMN_ID, note.getId());
        cv.put(Note.COLUMN_TITLE, note.getTitle());
        cv.put(Note.COLUMN_TEXT, note.getText());
        helper.getReadableDatabase().update(Note.TABLE_NAME, cv, Note.COLUMN_ID + " = ?", new String[]{note.getId().toString()} );
    }

    @Override
    public void deleteNote(long id) {
        helper.getReadableDatabase().delete(Note.TABLE_NAME, Note.COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
    }

    @Override
    public List<Note> getAllNotes() {

        Cursor cursor = helper.getReadableDatabase().rawQuery("SELECT * FROM " + Note.TABLE_NAME, null);

        List<Note> notes = new ArrayList<>();
        while (cursor.moveToNext()){
            Note note = new Note();
            note.setId(cursor.getLong(cursor.getColumnIndex(Note.COLUMN_ID)));
            note.setTitle(cursor.getString(cursor.getColumnIndex(Note.COLUMN_TITLE)));
            note.setText(cursor.getString(cursor.getColumnIndex(Note.COLUMN_TEXT)));
            notes.add(note);
        }

        return notes;
    }

    @Override
    public List<Note> getNotes(String search) {
        //TODO need implement
        return null;
    }
}
