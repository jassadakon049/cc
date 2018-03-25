package com.example.user.cc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User on 16/11/2560.
 */

public class StudentTable {

    private MySQLiteOpenHelper objMySQLiteOpenHelper;
    private SQLiteDatabase writeSqLiteDatabase;
    private SQLiteDatabase readSqLiteDatabase;

    public static final String Student_TABLE = "studenttable";
    public static final String Student_ID = "id_student";
    public static final String Student_NAME = "studentname";
    public static final String Student_SEC = "studentsec";


    public StudentTable(Context context){
        objMySQLiteOpenHelper = new MySQLiteOpenHelper(context);
        writeSqLiteDatabase = objMySQLiteOpenHelper.getWritableDatabase();
        readSqLiteDatabase = objMySQLiteOpenHelper.getReadableDatabase();
    }



    public String[] readALLStudentListTable(int intColume) {

        try {
            String[] strResult = null;
            Cursor objCursor = readSqLiteDatabase.query(Student_TABLE,
                    new String[]{Student_ID, Student_NAME, Student_SEC}, null, null, null, null, null);
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

    public long addNewstudent(String strName, String strLastname, String strSec){
        ContentValues objContentValues = new ContentValues();
        objContentValues.put(Student_ID,strName);
        objContentValues.put(Student_NAME,strLastname);
        objContentValues.put(Student_SEC,strSec);


        return readSqLiteDatabase.insert(Student_TABLE,null,objContentValues);

    }//end add student

    public String[] searchUsername(String Username){
        try {
            String[]  strResult=null;
            Cursor objCursor = readSqLiteDatabase.query(Student_TABLE,new String[]{Student_ID,Student_NAME,Student_SEC},
                    Student_ID+"=?",new String[]{String.valueOf(Username)},null,null,null);

            if(objCursor !=null){
                if(objCursor.moveToFirst() ){
                    strResult = new String[3];
                    strResult[0]=objCursor.getString(0);
                    strResult[1]=objCursor.getString(1);
                    strResult[2]=objCursor.getString(2);

                }

            }
            objCursor.close();
            return strResult;



        }catch (Exception e){
            return  null;
        }

    } //end searchUsername
}
