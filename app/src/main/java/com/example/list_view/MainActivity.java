package com.example.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void toArrary_list(View view) {
        //跳转布局
        Intent intent=new Intent(this,Arrarylist.class);
        startActivity(intent);
    }
    public void toSimple_list(View view){
        Intent intent=new Intent(this, SimpleList.class);
        startActivity(intent);
    }
    public void toBase_list(View view){
        Intent intent=new Intent(this, Baselist.class);
        startActivity(intent);
    }

}