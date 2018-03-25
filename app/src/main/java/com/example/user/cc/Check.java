package com.example.user.cc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class Check extends AppCompatActivity {

    private Button clicheckButton ;

    private CheckTable objCheckTable;
    private ListView CheckListView;

    String name;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);


        BindWidget();
        Cdatabase();
        createListView();
        clicheckButton = findViewById(R.id.button4);

        clicheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{

                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", new MainActivity().MODE_PRIVATE);
                     name = sharedPreferences.getString("nameKey", null);

                    addatacheck();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"ไม่ได้",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void addatacheck(){
        objCheckTable.addCheck(name,date);
        Intent i = new Intent(Check.this,Check.class);
        startActivity(i);
    }


    private void createListView(){
        final String[] checkname = objCheckTable.readALLCheckListTable(0);
        final String[] checktime = objCheckTable.readALLCheckListTable(1);

        final AdapterCheck objMyAdapterCheck = new AdapterCheck(Check.this,checkname,checktime);
        CheckListView.setAdapter(objMyAdapterCheck);
    }

    private void Cdatabase(){
        objCheckTable = new CheckTable(this);
    }

    private void BindWidget(){
        CheckListView = (ListView)findViewById(R.id.checklist);
    }

}
