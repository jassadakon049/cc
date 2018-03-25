package com.example.user.cc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class insertstudent extends AppCompatActivity {

    String A, B, C;
    EditText aa, bb, cc;

    private StudentTable objStudentTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertstudent);

        connect();
    }
    public  void addstudent(View view){

        aa = findViewById(R.id.studentid);
        bb = findViewById(R.id.studentname);
        cc = findViewById(R.id.studentsec);


        A = aa.getText().toString().trim();
        B = bb.getText().toString().trim();
        C = cc.getText().toString().trim();


        Intent i = new Intent(insertstudent.this,MainActivity.class);
        addstudent();
        startActivity(i);

    }

    public void addstudent(){
        objStudentTable.addNewstudent(A,B,C);
    }

    public  void connect (){

        objStudentTable = new StudentTable(this);
    }//end connect

    public void cliback(View view){

        finish();
    }
}
