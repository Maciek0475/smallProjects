package com.example.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteManager extends SQLiteOpenHelper {
    public static final String DBNAME = "todo.db";
    public static final String TABLENAME = "tasks";
    public static final String TITLE = "tytul";
    public static final String DESC = "opis";
    public static final String DATE = "data_rozpoczecia";
    public static final String DONE = "zrobione";
    public static final String ID = "id";
    public static final int VER = 1;
    public SQLiteManager(@Nullable Context context) {
        super(context, DBNAME, null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table "+TABLENAME+"(id integer primary key, tytul text, opis text, data_rozpoczecia text, zrobione text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="drop table if exists "+TABLENAME;
        db.execSQL(query);

        onCreate(db);
    }
    public boolean insertData(String tytul, String opis, String data_rozpoczecia, String zrobione){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TITLE, tytul);
        cv.put(DESC, opis);
        cv.put(DATE, data_rozpoczecia);
        cv.put(DONE, zrobione);

        long results = db.insert(TABLENAME, null, cv);
        return results != -1;
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * FROM "+TABLENAME;
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLENAME, "id = ?", new String[]{id});
    }
    public boolean updateData(String id, String tytul, String opis, String zrobione){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TITLE, tytul);
        cv.put(DESC, opis);
        cv.put(DONE, zrobione);
        Integer result = db.update(TABLENAME, cv, "id=?", new String[]{id});
        if(result < 0){
            return true;
        } else{
            return false;
        }
    }
}
