package com.els.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by ericaschulz on 6/17/16.
 */
public class ToDoList extends AppCompatActivity {

    private TextView mTxtName;
    private TextView mTxtDesc;

    private Intent mIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to_do_list);

        mIntent = getIntent();
        mTxtName = (TextView) findViewById(R.id.to_do_name);
        mTxtDesc = (TextView) findViewById(R.id.to_do_desc);

        mTxtName.setText(mIntent.getStringExtra("NAME"));
        mTxtDesc.setText(mIntent.getStringExtra("DESC"));

    }





}
