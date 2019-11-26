package com.github.kiolk.notebook;

import android.app.Application;

import com.github.kiolk.notebook.data.repositores.note.DefaultNoteRepository;
import com.github.kiolk.notebook.data.repositores.note.NoteRepository;
import com.github.kiolk.notebook.data.repositores.note.local.LocalNoteSource;

public class App extends Application {

    private static NoteRepository noteRepository;
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static NoteRepository getNoteRepositoryInstance(){
        if(noteRepository == null){
            noteRepository = new DefaultNoteRepository(new LocalNoteSource(instance.getBaseContext()));
        }
        return  noteRepository;
    }
}
