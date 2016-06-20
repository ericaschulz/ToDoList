package com.els.todolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ListView mListView;
    private ListView mListView2;
    private ArrayList<String> mList;
    private ArrayList<String> mItemDetail;
    //private ArrayList<ArrayList<String>>mList = new ArrayList<>();
    //private ArrayList<String>mItemDetail = new ArrayList<>();
    private ArrayAdapter<String>mArrayAdapter;
    private ArrayAdapter<String>mArrayAdapter2;
    private AdapterView.OnItemLongClickListener mListener;
    private EditText mTextEdit;
    private Button mButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mList = new ArrayList<>();

        mTextEdit = (EditText)findViewById(R.id.ent_txt);

        //mItemDetail = new ArrayList<>();
        //mItemDetail.add("bread");
        //mItemDetail.add("oil change");


        mListView = (ListView) findViewById(R.id.to_do_list_main);
        //mListView2 = (ListView) findViewById(R.id.item_detail_main);


        mArrayAdapter = new ArrayAdapter<>(this, R.layout.to_do_list, mList);
        //mArrayAdapter2 = new ArrayAdapter<>(this, R.layout.list_row_item, mItemDetail);

        mListView.setAdapter(mArrayAdapter);
        //mListView2.setAdapter(mArrayAdapter2);

        mListener = new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        };



        mListView.setOnItemLongClickListener(mListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EditText input = (EditText)findViewById(R.id.ent_txt);
                    mList.add(input.getText().toString());
                    mArrayAdapter.notifyDataSetChanged();
                    input.setText("");

                }
            });
        }
        mButton = (Button)findViewById(R.id.clear_all);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mList.clear();
                mArrayAdapter.notifyDataSetChanged();

            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    }


