package com.example.user.cc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by User on 21/11/2560.
 */

public class CheckTable {
    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String Check_TABLE = "checktable";
    public static final String Check_ID = "id_check";
    public static final String Check_NAME = "checkname";
    public static final String Check_TIME = "checktime";

    public CheckTable(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }

    public long addCheck(String namestudent,String formattedDate ){
        ContentValues objContentValues = new ContentValues();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        formattedDate = df.format(c.getTime());

        objContentValues.put(Check_TIME,formattedDate);
        objContentValues.put(Check_NAME,namestudent);

        return readSqLiteDatabase.insert(Check_TABLE,null,objContentValues);
    }

    public String[] readALLCheckListTable(int intColume) {

        try {
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(Check_TABLE,
                    new String[]{Check_NAME,Check_TIME}, null, null, null, null, null);
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
