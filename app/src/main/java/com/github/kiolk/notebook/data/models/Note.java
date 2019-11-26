package com.github.kiolk.notebook.data.models;

import java.io.Serializable;

public class Note implements Serializable {

    public static final String COLUMN_ID = "note_id";
    public static final String COLUMN_TITLE = "note_title";
    public static final String COLUMN_TEXT = "note_text";
    public static final String COLUMN_CREAT = "note_create";
    public static final String COLUMN_UPDATE = "note_update";

    public static final String TABLE_NAME = "notes";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_TITLE + " TEXT,"
                    + COLUMN_TEXT + " TEXT,"
                    + COLUMN_CREAT + " INTEGER,"
                    + COLUMN_UPDATE + " INTEGER"
                    + ")";

    private Long id;
    private String title;
    private String text;
    private Long createTime;
    private Long lastChangeTime;

    public Note() { }

    public Note(String title, Long id, String text, Long createTime, Long lastChangeTime) {
        this.title = title;
        this.id = id;
        this.text = text;
        this.createTime = createTime;
        this.lastChangeTime = lastChangeTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Long lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }


}
