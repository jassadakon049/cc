package com.example.user.cc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 17/11/2560.
 */

public class SecTable {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String Sec_TABLE = "sectable";
    public static final String Sec_ID = "id_sec";
    public static final String Sec_NAME = "secname";
    public static final String Sec_TIME = "sectime";
    public static final String Sec_TEACHER = "secteacher";
    public static final String Sec_DAY = "secday";

    public SecTable(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addNewstudent(String strName, String strTime, String strTeacher,String strDay){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(Sec_NAME,strName);
        objContentValues.put(Sec_TIME,strTime);
        objContentValues.put(Sec_TEACHER,strTeacher);
        objContentValues.put(Sec_DAY,strDay);

        return readSqLiteDatabase.insert(Sec_TABLE,null,objContentValues);

    }

    public String[] readALLStudentListTable(int intColume) {

        try {
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(Sec_TABLE,
                    new String[]{Sec_NAME, Sec_TIME, Sec_TEACHER,Sec_DAY}, null, null, null, null, null);
            if (objCursor != null) {
                if (objCursor.moveToFirst()) {
                    int num = objCursor.getCount();
                    strResult = new String[num];
                    for (int i = 0; i < num; i++) {
                        strResult[i] = objCursor.getString(intColume);
                        objCursor.moveToNext();
                    }
                }
            }
            objCursor.close();
            return strResult;
        } catch (Exception e) {
            return null;
        }
    }
}
