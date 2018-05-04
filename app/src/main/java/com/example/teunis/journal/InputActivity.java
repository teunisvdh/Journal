package com.example.teunis.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    // add journal
    public void addEntry(View view) {
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert();
    }
}
