package com.example.user.cc;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by User on 21/11/2560.
 */

public class AdapterCheck extends BaseAdapter {

    private Context objContextstudent;
    private String[] checkname,checktime;

    public AdapterCheck(Context context,String[] checkname,String[] checktime){
        this.objContextstudent = context;
        this.checkname = checkname;
        this.checktime = checktime;

    }

    @Override
    public int getCount() {
        return checkname.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        LayoutInflater objLayoutInflater = (LayoutInflater) objContextstudent.getSystemService(objContextstudent.LAYOUT_INFLATER_SERVICE);
        View view = objLayoutInflater.inflate(R.layout.listviewcheck,parent,false);

        TextView nameTextView = (TextView) view.findViewById(R.id.checkname);
        TextView timeTextView = (TextView) view.findViewById(R.id.checktime);

        nameTextView.setText(checkname[position]);
        timeTextView.setText(checktime[position]);

        return view;
    }
}
