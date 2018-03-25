package com.example.user.cc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by User on 17/11/2560.
 */

public class AdapterStudent extends BaseAdapter {

    private Context objContextstudent;
    private String[] idstudent,namestudent,secstudent;

    public AdapterStudent(Context context,String[] idstudent,String[] namestudent,String[] secstudent){
        this.objContextstudent = context;
        this.idstudent = idstudent;
        this.namestudent = namestudent;

    }

    @Override
    public int getCount() {
        return idstudent.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objContextstudent.getSystemService(objContextstudent.LAYOUT_INFLATER_SERVICE);
        View view = objLayoutInflater.inflate(R.layout.listviewstudent,parent,false);

        TextView idTextView = (TextView) view.findViewById(R.id.studentidview);
        TextView nameTextView = (TextView) view.findViewById(R.id.studentnameview);


        idTextView.setText(idstudent[position]);
        nameTextView.setText(namestudent[position]);


        return view;
    }
}
