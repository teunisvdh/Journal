package com.example.teunis.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import java.sql.Timestamp;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }

    // place specific text in views
    public void bindView(View view, Context context, Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("TIMESTAMP");
        int columnIndexTitle = cursor.getColumnIndex("TITLE");
        int time = cursor.getInt(columnIndex);
        int title = cursor.getInt(columnIndexTitle);
        TextView titlePlaceholder = view.findViewById(R.id.titlePlaceholder);
        TextView timePlaceholder = view.findViewById(R.id.timePlaceholder);
        timePlaceholder.setText(time);
        titlePlaceholder.setText(title);
    }
}
