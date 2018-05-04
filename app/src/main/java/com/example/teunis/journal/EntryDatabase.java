package com.example.teunis.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "journaldatabase";
    private static EntryDatabase instance;

    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // make singleton
    public static EntryDatabase getInstance(Context c) {
        if (instance == null) {
            instance = new EntryDatabase(c, DB_NAME, null, 1);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // create table
        String sqlQuery = "CREATE TABLE " + DB_NAME +
                " (_id INTEGER PRIMARY KEY AUTOINCREMENT, TITLE TEXT, CONTENT TEXT, MOOD TEXT, TIMESTAMP TEXT)";
        db.execSQL(sqlQuery);

        // insert to test
        String input1 = "INSERT INTO " + DB_NAME + " VALUES ('Today', 'blablabla', 'sad', datetime())";
        String input2 = "INSERT INTO " + DB_NAME + " VALUES ('Yesterday', 'bla', 'happy', datetime())";
        db.execSQL(input1);
        db.execSQL(input2);
    }

    // drop table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDrop = "DROP TABLE IF EXISTS " + DB_NAME;
        db.execSQL(sqlDrop);
        onCreate(db);
    }

    // select all data from table
    public Cursor selectAll() {
        SQLiteDatabase thisDatabase = getWritableDatabase();
        Cursor select = (thisDatabase.rawQuery("SELECT * FROM " + DB_NAME, null));
        return select;
    }

    // insert data
    public void insert(JournalEntry entry) {
        SQLiteDatabase thatDatabase = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("title", "content", "mood");
        thatDatabase.insert(DB_NAME, null, content);
    }

    // delete data
    public void delete(long id, SQLiteDatabase db) {
        String sqlDelete = "REMOVE * FROM " + DB_NAME + " WHERE _id = " + id;
        db.execSQL(sqlDelete);
        onCreate(db);
    }

}
