package com.example.helios.draglistview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.helios.draglistview.adapter.DragListViewAdapter;
import com.example.helios.draglistview.view.DragView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "bonus";
    private List<Object> mData = new ArrayList<>();
    private DragListViewAdapter mAdapter;
    private DragView mDragView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mDragView = (DragView) findViewById(R.id.dragView);
        initData();
        setDragListViewAdapter();
    }

    private void setDragListViewAdapter() {

        mAdapter = new DragListViewAdapter(MainActivity.this,R.layout.drag_listview_item_layout);
        for (int i = 0 ; i < mData.size() ; i++){
            mAdapter.add(mData.get(i));
        }
//        mDragListView.setAdapter(mAdapter);
        mDragView.setAdapter(mAdapter);
    }

    /**
     * 初始化listview数据
     */
    private void initData() {
        for (int i = 0 ; i < 20 ; i++){
            mData.add("item数据 "+i);
        }
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
