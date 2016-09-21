package com.example.hannes.barwatch.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hannes.barwatch.item.BarItem;

import java.util.ArrayList;

/**
 * Created by Robin on 28.08.16.
 */




public class BarDatabase {
    private static final String DATABASE_NAME = "favoriten.db";
    private static final int DATABASE_VERSION = 2;

    public static final String KEY_ID = "_id";
    public static final String KEY_TIME = "time";
    public static final String KEY_NAME = "name";
    public static final String KEY_ANGEBOT = "angebot";
    //public static final float KEY_LAT = "lat";
    //public static final float KEY_LNG = "lng";

    private static final String DATABASE_TABLE = "favoriten";

    private static final int COLUMN_TIME_INDEX=2;
    private static final int COLUMN_FAV_INDEX = 1;
    private static final int COLUMN_ANGEBOT_INDEX = 3;


    private ToDoDBOpenHelper dbHelper;

    private SQLiteDatabase db;

    public BarDatabase(Context context){
        dbHelper = new ToDoDBOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void open() throws SQLException{
        try {
            db = dbHelper.getWritableDatabase();
        }catch (SQLException e){
            db = dbHelper.getReadableDatabase();
        }
    }

    public void close() { db.close();}

    public long insertFavorite(BarItem fav){
        ContentValues newFavValues = new ContentValues();

        newFavValues.put(KEY_TIME, fav.getTime());
        newFavValues.put(KEY_NAME, fav.getName());
        newFavValues.put(KEY_ANGEBOT, fav.getAngebote());

        return db.insert(DATABASE_TABLE, null, newFavValues);
    }

    /*public void removeFavItem(BarItem fav){
        String whereClause = KEY_NAME + " = '" + fav.getName() + "'";

        db.delete(DATABASE_TABLE, whereClause, null);
    }*/

    public ArrayList<BarItem> getAllToDoItems(){
        ArrayList<BarItem> favoriten = new ArrayList<BarItem>();
        String[] allColumns = new String[] {KEY_ID, KEY_NAME, KEY_TIME, KEY_ANGEBOT};
        Cursor cursor = db.query(DATABASE_TABLE, allColumns, null, null, null, null, null);
        if(cursor.moveToFirst()){
            do{
                String time = cursor.getString(COLUMN_TIME_INDEX);
                String fav = cursor.getString(COLUMN_FAV_INDEX);
                String angebot = cursor.getString(COLUMN_ANGEBOT_INDEX);
                favoriten.add(new BarItem(time, fav, angebot));

            }
            while(cursor.moveToNext());
        }
        return favoriten;
    }


    private class ToDoDBOpenHelper extends SQLiteOpenHelper{

        private static final String DATABASE_CREATE = "create table "
                + DATABASE_TABLE + " (" + KEY_ID
                + " integer primary key autoincrement, " + KEY_NAME + " text not null, " + KEY_TIME
                + " text not null, " + KEY_ANGEBOT + " text not null);";


        public ToDoDBOpenHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int databaseVersion) {
            super(context, databaseName, factory, databaseVersion);

        }
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
