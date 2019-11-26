package com.github.kiolk.notebook.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.kiolk.notebook.R;
import com.github.kiolk.notebook.data.models.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    interface NoteClickListener{
        void onNoteClick(Note note);
    }

    private NoteClickListener listener;
    private List<Note> notes = new ArrayList<>();

    public NoteAdapter(NoteClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_note, parent, false);
        return new NoteViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.onViewBound(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    void setData(List<Note> newNotes){
        notes.clear();
        notes.addAll(newNotes);
        notifyDataSetChanged();

    }

    class NoteViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTitle;
        private NoteClickListener listener;

        public NoteViewHolder(@NonNull View itemView, NoteClickListener listener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_note);
            this.listener = listener;
        }

        void onViewBound(final Note note){
            tvTitle.setText(note.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onNoteClick(note);
                }
            });
        }
    }
}
