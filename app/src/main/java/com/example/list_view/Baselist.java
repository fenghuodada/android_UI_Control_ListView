package com.example.list_view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Baselist extends AppCompatActivity {
    //创建列表控件
    ListView listView;
    //创建数据源
    List<Item> data;
    //创建适配器
    MyDifineAdapter myDifineAdapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_list);
        //实例化列表控件
        listView=findViewById(R.id.listview_3);
        //创建数据
        data=new ArrayList<>();
        //对数据源进行调用和修改
        Item item_1=new Item();
        item_1.setTitle("标题1");
        item_1.setEssay("文章1");
        item_1.setImagesid(R.mipmap.test1);

        Item item_2=new Item();
        item_2.setTitle("标题2");
        item_2.setEssay("文章2");
        item_2.setImagesid(R.mipmap.test2);

        Item item_3=new Item();
        item_3.setTitle("标题3");
        item_3.setEssay("文章3");
        item_3.setImagesid(R.mipmap.test3);

        Item item_4=new Item();
        item_4.setTitle("标题4");
        item_4.setEssay("文章4");
        item_4.setImagesid(R.mipmap.test4);

        Item item_5=new Item();
        item_5.setTitle("标题5");
        item_5.setEssay("文章5");
        item_5.setImagesid(R.mipmap.test5);

        //设置添加数据
        data.add(item_1);
        data.add(item_2);
        data.add(item_3);
        data.add(item_4);
        data.add(item_5);
        data.add(item_4);
        data.add(item_3);
        data.add(item_3);
        data.add(item_2);
        data.add(item_3);
        data.add(item_5);
        data.add(item_4);
        data.add(item_3);
        data.add(item_4);
        data.add(item_3);
        data.add(item_2);
        data.add(item_1);
        data.add(item_5);
        data.add(item_1);
        data.add(item_5);
        data.add(item_1);
        data.add(item_2);
        data.add(item_3);
        data.add(item_4);
        data.add(item_5);
        data.add(item_4);
        data.add(item_3);
        data.add(item_3);
        data.add(item_2);
        data.add(item_3);
        data.add(item_5);
        data.add(item_4);
        data.add(item_3);
        data.add(item_4);
        data.add(item_3);
        data.add(item_2);
        data.add(item_1);
        data.add(item_5);
        data.add(item_1);
        data.add(item_5);

        //实例化适配器
        myDifineAdapter=new MyDifineAdapter(data,this);
        //对列表调用适配器
        listView.setAdapter(myDifineAdapter);
        //对列表设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Baselist.this, "点击成功", Toast.LENGTH_SHORT).show();
            }
        });

    }





}
