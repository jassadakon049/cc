package com.example.user.cc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class studentlist extends AppCompatActivity {

    private StudentTable objStudentTable;
    private ListView StudentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlist);

        BindWidget();
        Cdatabase();
        createListView();
    }

    private void createListView(){
        final String[] idstudent = objStudentTable.readALLStudentListTable(0);
        final String[] namestudent = objStudentTable.readALLStudentListTable(1);
        final String[] secstudent = objStudentTable.readALLStudentListTable(2);

        final AdapterStudent objMyAdapterStudent = new AdapterStudent(studentlist.this,idstudent,namestudent,secstudent);
        StudentListView.setAdapter(objMyAdapterStudent);
    }

    private void Cdatabase(){
        objStudentTable = new StudentTable(this);
    }

    private void BindWidget(){
        StudentListView = (ListView)findViewById(R.id.studentlist);
    }

    public void studentadd (View view){
        Intent i = new Intent(studentlist.this,insertstudent.class);
        startActivity(i);
    }
}
