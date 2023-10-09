package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleList extends AppCompatActivity {


    //声明控件
    ListView listView;
    //声明数据源
    List<Map<String,Object>> date;
    //声明适配器
    SimpleAdapter simpleAdapter;
    //声明图片资源
    int[] image={R.mipmap.test1,R.mipmap.test2,R.mipmap.test3,R.mipmap.test4,R.mipmap.test5};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liner_layout);
        //实例化控件
        listView=findViewById(R.id.listview_2);
        //实例数据源
        date=new ArrayList<>();
        //对数据源进行赋值
        for (int i = 0; i < 50; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("image",image[i% image.length]);
            map.put("title","这是第"+(i+1)+"个标题");
            map.put("article","这是第"+(i+1)+"段");
            date.add(map);
        }
        //实例化SimpleAadpter
        simpleAdapter=new SimpleAdapter(this,date,R.layout.activity_simple_list,new String[]{"image","title","article"},new int[]{R.id.image,R.id.text_view_1,R.id.text_view_2});
        //对列表进行适配
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //确定数据资源的具体位置，并且赋值给一个对象
                Map<String,Object> map=date.get(i);
                //提取具体位置中的相关元素
                String title= (String) map.get("title");
                Toast.makeText(SimpleList.this, "点击成功"+i+title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}