package com.example.cs_ia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class dataBaseHelper extends SQLiteOpenHelper {

    public static final String LIST_NAME_TABLE = "ListName_TABLE";
    public static final String LIST_NAME = "LIST_NAME";
    public static final String LIST_ICON = "LIST_ICON";
    public static final String COLUMN_ID = "ID";

    public dataBaseHelper(@Nullable Context context) {
        super(context, "listname.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createtablestatement = "CREATE TABLE " + LIST_NAME_TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LIST_NAME + " TEXT)";
        db.execSQL(createtablestatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //METHOD TO INSERT THE DATA
    public boolean addone(listName_model listNameModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(LIST_NAME, listNameModel.getName());
        long insert = db.insert(LIST_NAME_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<listName_model> getEveryone() {
        List<listName_model> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM " + LIST_NAME_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        if (cursor.moveToFirst()) {
            do {
                int ListID = cursor.getInt(0);
                String listName = cursor.getString(1);
                listName_model newList = new listName_model(ListID, listName);
                returnList.add(newList);
            } while (cursor.moveToNext());
        } else {

        }

        cursor.close();
        db.close();
        return returnList;
    }
}
