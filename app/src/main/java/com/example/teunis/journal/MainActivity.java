package com.example.teunis.journal;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.teunis.journal.EntryDatabase.DB_NAME;

public class MainActivity extends AppCompatActivity {

    // accessing details of item
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // Intent, Entry, Bundle
        }
    }

    // deleting item
    private class ListItemLongClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            return false;
        }

        // delete items
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        Cursor cursor = db.selectAll();

        // link adapter to listView
        EntryAdapter adapter = new EntryAdapter(this, cursor);
        ListView dynamic = findViewById(R.id.listJournal);
        dynamic.setAdapter(adapter);
    }

    // floatbutton clicked: input a journal
    public void floatClicked(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    // update after change
    private void updateData() {

        // use instances, swapCursor(), onResume()
    }
}
