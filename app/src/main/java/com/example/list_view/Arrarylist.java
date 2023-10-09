package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Arrarylist extends AppCompatActivity {

    //声明数据源列表
    List<String> datelist;
    //声明列表视图控件
    ListView listView;
    //声明适配器ArraryAdapter
    ArrayAdapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrarylist);
        //实例化数据源
        datelist=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datelist.add("这是第"+(i+1)+"行");
        }
        //实例化列表视图
        listView=findViewById(R.id.listview);
        //实例化适配器
        adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,datelist);
        //连接视图和数据源
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Arrarylist.this, "这是第"+(i+1)+"行", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Arrarylist.this, "长按成功", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

}