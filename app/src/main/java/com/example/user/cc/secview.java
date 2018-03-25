package com.example.user.cc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class secview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secview);
    }
    public void cliback(View view){

        finish();
    }
}
