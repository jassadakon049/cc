package com.example.user.cc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainTeacher extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_teacher);
    }
    public void btn_tea_student(View view){
        Intent i = new  Intent(MainTeacher.this,studentlist.class);
        startActivity(i);
    }
}
