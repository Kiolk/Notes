package com.github.kiolk.notebook.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import com.github.kiolk.notebook.App;
import com.github.kiolk.notebook.R;
import com.github.kiolk.notebook.data.models.Note;
import com.github.kiolk.notebook.ui.add.AddNoteActivity;

import java.util.List;

import static com.github.kiolk.notebook.ui.add.AddNoteActivity.NOTE;

public class MainActivity extends AppCompatActivity implements NoteAdapter.NoteClickListener {

    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new NoteAdapter(this);
        RecyclerView recycler = findViewById(R.id.tv_note_recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.tb_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            toolbar.inflateMenu(R.menu.main_menu);
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if(item.getItemId() == R.id.add){
                        startActivity(new Intent(getBaseContext(), AddNoteActivity.class));
                    }
                    return false;
                }
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Note> notes = App.getNoteRepositoryInstance().getAllNotes();
        adapter.setData(notes);
    }

    @Override
    public void onNoteClick(Note note) {
        Intent intent = new Intent(getBaseContext(), AddNoteActivity.class);
        intent.putExtra(NOTE, note);
        startActivity(intent);
    }

    //TODO implement logic for handle search text change and update recycler
}
