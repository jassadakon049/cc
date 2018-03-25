package com.example.user.cc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class studentlistview extends AppCompatActivity {

    private StudentTable objStudentTable;
    private ListView StudentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentlistview);

        BindWidget();
        Cdatabase();
        createListView();
    }
    private void createListView(){
        final String[] idstudent = objStudentTable.readALLStudentListTable(0);
        final String[] namestudent = objStudentTable.readALLStudentListTable(1);


        final AdapterStudent objMyAdapterStudent = new AdapterStudent(studentlistview.this,idstudent,namestudent,null);
        StudentListView.setAdapter(objMyAdapterStudent);
    }

    private void Cdatabase(){
        objStudentTable = new StudentTable(this);
    }

    private void BindWidget(){
        StudentListView = (ListView)findViewById(R.id.studentlist);
    }
}
