package com.example.march14;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(Context context) {
        super(context, "Userdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Userdetails(name TEXT primary key, contact TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Userdetails");
    }

    public Boolean insertUserData(String name, String contact){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("contact", contact);

        long result = DB.insert("Userdetails", null, contentValues);

        if(result == -1){
            return  false;
        }
        else{
            return true;
        }
    }

    public Boolean updateUserData(String name, String contact){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("contact", contact);

        Cursor cursor = DB.rawQuery("select * from Userdetails where name=?", new String[] {name});

        if(cursor.getColumnCount() > 0){
            long result = DB.update("Userdetails", contentValues, "name=?", new String[] {name});

            if(result == -1){
                return false;
            }else {
                return true;
            }

        } else{
            return false;
        }

    }

    public Boolean deleteUserData(String name){
        SQLiteDatabase DB = this.getWritableDatabase();

        Cursor cursor = DB.rawQuery("select * from Userdetails where name=?", new String[] {name});

        if(cursor.getColumnCount() > 0){
            long result = DB.delete("Userdetails", "name=?", new String[] {name});

            if(result == -1){
                return false;
            }else {
                return true;
            }

        } else{
            return false;
        }
    }

    public Cursor getData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from Userdetails", null);

        return cursor;
    }
}
