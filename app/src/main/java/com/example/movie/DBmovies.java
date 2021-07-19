package com.example.movie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmovies extends SQLiteOpenHelper {
    public DBmovies(Context context) {
        super(context, "Moviedatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails(original_title TEXT primary key,release_date TEXT,poster_path TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertuserdata(String original_title,String release_date,String poster_path)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("name",original_title);
        contentValues.put("date",release_date);
        contentValues.put("poster",poster_path);

        long result = DB.insert("Userdetails",null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }
    }

    public Boolean updateuserdata(String name,String contact,String dob)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);

        Cursor cursor=DB.rawQuery("Select * from Userdetails where name=?",new String[]{name});
        if (cursor.getCount()>0){
            long result=DB.update("Userdetails",contentValues,"name=?",new String[]{name});
            if (result==-1){
                return false;
            }
            else {
                return true;
            }
        }else {

            return false;
        }
    }

    public Boolean deletedata(String name)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from Userdetails where name=?",new String[]{name});
        if (cursor.getCount()>0){
            long result=DB.delete("Userdetails","name=?",new String[]{name});
            if (result==-1){
                return false;
            }
            else {
                return true;
            }
        }else {
            return false;
        }
    }

    public Cursor getdata()
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from Userdetails",null);
        return cursor;
    }

    public void insert_data(String smname, String smdate, String sposter) {

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("original_title",smname);
        contentValues.put("release_date",smdate);
        contentValues.put("poster_path",sposter);

        DB.insert("Moviedatabase",null,contentValues);

    }
}
