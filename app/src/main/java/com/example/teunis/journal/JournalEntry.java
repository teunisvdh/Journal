package com.example.teunis.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    public int id;
    public String title, content, mood, timestamp;

    public JournalEntry(int id, String title, String content, String mood, String timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }
}
