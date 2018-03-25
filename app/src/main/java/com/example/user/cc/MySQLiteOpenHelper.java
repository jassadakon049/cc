package com.example.user.cc;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by User on 16/11/2560.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase;

    public static final String DataBase_Name = "cc.db";
    public static final int DataBase_Version = 1;

    public static final String Student_TABLE = "studenttable";
    public static final String Student_ID = "id_student";
    public static final String Student_NAME = "studentname";
    public static final String Student_SEC = "studentsec";

    public static final String CREATE_STUDENT_TABLE = "create table " + Student_TABLE + "(" + Student_ID + " text primary key, " + " " + Student_NAME + " text, "
            + Student_SEC + " text);";


    public static final String Check_TABLE = "checktable";
    public static final String Check_ID = "id_check";
    public static final String Check_NAME = "checkname";
    public static final String Check_TIME = "checktime";
    public static final String CREATE_CHECK_TABLE = "create table " + Check_TABLE + "(" + Check_ID + " integer primary key, " + " " + Check_NAME + " text, "
            + Check_TIME + " integer);";



    public MySQLiteOpenHelper(Context context) {
        super(context,DataBase_Name,null,DataBase_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,CREATE_STUDENT_TABLE);
        Log.i(TAG,CREATE_CHECK_TABLE);
        db.execSQL(CREATE_STUDENT_TABLE);
        db.execSQL(CREATE_CHECK_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_STUDENT_TABLE = "DROP TABLE IF EXISTS " + Student_TABLE;

        db.execSQL(DROP_STUDENT_TABLE);

        Log.i(TAG, "Upgrade Database from " + oldVersion + " to " + newVersion);

        onCreate(db);
    }
}


