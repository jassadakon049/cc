package com.example.user.cc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_student);
    }

    public void btn_std_student(View view){
        Intent i = new Intent(MainStudent.this,studentlistview.class);
        startActivity(i);
    }

    public void btn_sec(View view){
        Intent i = new Intent(MainStudent.this,secview.class);
        startActivity(i);
    }

    public void gocheck(View view){
        Intent i = new Intent(MainStudent.this,Check.class);
        startActivity(i);
    }
}
