package com.github.kiolk.notebook.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.github.kiolk.notebook.data.models.Note;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 3;
    public static final String DB_NAME = "NOTE_DATABASE";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Note.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Note.TABLE_NAME);

        onCreate(db);
    }
}
