package com.example.user.cc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    StudentTable objStudentTable;

    EditText  username , password ;
    String strusernaem, strpassword ;

    SharedPreferences sharedpreferences;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String NameMem = "nameKey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        connect();



    }//endactivitymain


    public void btn_login(View view) {

        username = findViewById(R.id.login_id);
        password = findViewById(R.id.login_pass);


        strusernaem = username.getText().toString().trim();
        strpassword = password.getText().toString().trim();

        String name=null;
        checkUsername(strusernaem,strpassword,name);




    }

    public void cliregis(View view){  // intent ไปหน้าสมัคร
        Intent regisIntent = new Intent(MainActivity.this,insertstudent.class);
        startActivity(regisIntent);
    }//end intent register


    private void checkUsername(String UsernameString ,String PasswordString ,String name){

        try {
            String[] strMyresult= objStudentTable.searchUsername(UsernameString);

            if(PasswordString.equals(strMyresult[2])){

                name = strMyresult[1];
                SharedPreferences.Editor editor = sharedpreferences.edit(); // เก็บค่า
                editor.putString(NameMem,name);
                editor.commit();


                Intent logonintent = new Intent(MainActivity.this,MainStudent.class);
                startActivity(logonintent);

                Toast.makeText(getApplicationContext(),"ล็อคอินสำเร็จ",Toast.LENGTH_LONG).show();


            }else{
                Toast.makeText(getApplicationContext(),"ไอดีหรือพาสเวิสผิด",Toast.LENGTH_LONG).show();
            }
        }catch(Exception e){

            Toast.makeText(getApplicationContext(),"ไม่มีข้อมูล",Toast.LENGTH_LONG).show();
        }

    }//endcheckUsername

    public void connect(){

        objStudentTable = new StudentTable(this);
    }

}// endclass