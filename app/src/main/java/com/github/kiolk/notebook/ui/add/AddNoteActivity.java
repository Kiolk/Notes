package com.github.kiolk.notebook.ui.add;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.github.kiolk.notebook.App;
import com.github.kiolk.notebook.R;
import com.github.kiolk.notebook.data.models.Note;

public class AddNoteActivity extends AppCompatActivity {

    public static final String NOTE = "NOTE";
    private EditText etTitle;
    private EditText etText;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        etTitle = findViewById(R.id.et_title);
        etText = findViewById(R.id.et_text);

        Intent inputIntent = getIntent();
        if (inputIntent != null) {
            note = (Note) inputIntent.getSerializableExtra(NOTE);
            String title = null;
            String text = null;
            if (note != null) {
                title = note.getTitle();
                text = note.getText();
            }

            etTitle.setText(title);
            etText.setText(text);
        }

        Toolbar toolbar = findViewById(R.id.tb_add_toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteNote();
                }
            });
            toolbar.inflateMenu(R.menu.add_menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.save) {
                        saveNote();
                    }
                    return false;
                }
            });
        }
    }

    private void saveNote() {
        if (note != null) {
            note.setText(etText.getText().toString());
            note.setTitle(etTitle.getText().toString());
            App.getNoteRepositoryInstance().updateNote(note);
        } else {
            Note note = new Note();
            note.setText(etText.getText().toString());
            note.setTitle(etTitle.getText().toString());
            App.getNoteRepositoryInstance().insertNote(note);
        }
        finish();
    }

    private void deleteNote() {
        if (note != null) {
            App.getNoteRepositoryInstance().deleteNote(note.getId());
        }
        finish();
    }
}
