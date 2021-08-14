package com.example.movie;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBmovies extends SQLiteOpenHelper {
    Context context;
    Adapter_movie_fav adapter_movie_fav;

    private static final String Userdetails = "Userdetails";

    public DBmovies(Context context) {
        super(context, "Moviedatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails( original_title TEXT PRIMARY KEY ,release_date TEXT,poster_path TEXT,original_language TEXT,vote_average TEXT,overview TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
      //  onCreate(DB);
    }


    public boolean insert_data(String dsmname, String dsmdate, String dsposter , String dslanguage ,String dsvote ,String dsoverview) {

        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("original_title",dsmname);
        contentValues.put("release_date",dsmdate);
        contentValues.put("poster_path",dsposter);
        contentValues.put("original_language",dslanguage);
        contentValues.put("vote_average",dsvote);
        contentValues.put("overview",dsoverview);

     long res= DB.insert("Userdetails",null,contentValues);

     if (res==-1)
     {
         return false;
     }else {
         return true;
     }

    }


    Cursor readAllData(){
        String query = "SELECT * FROM " + Userdetails;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
     }


    public Boolean deletedata(String name)
    {
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from Userdetails where original_title=?",new String[]{name});
        if (cursor.getCount()>0){
            long result=DB.delete("Userdetails","original_title=?",new String[]{name});
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


}
