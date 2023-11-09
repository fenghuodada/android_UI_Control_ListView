package com.example.list_view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("tag","onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("tag","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("tag","onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("tag","onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("tag","onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("tag","onRestart");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*        Log.i("tag","concreat");
        Log.d("tag","concreat");
        Log.w("tag","concreat");
        Log.e("tag","concreat");
        Log.wtf("tag","concreat");*/
        Log.v("tag","concreat");

    }
    public void toArrary_list(View view) {
/*        //显式跳转布局
        Intent intent=new Intent(this,Arrarylist.class);
        startActivity(intent);*/
        //隐式跳转你布局
        Intent intent =new Intent();
        intent.setAction("TextActivity");
        intent.addCategory("android.intent.category.ArraryList");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }
    public void toSimple_list(View view){
        //隐式跳转
        Intent intent=new Intent();
        intent.setAction("TextActivity");
        intent.addCategory("android.intent.category.Simple");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        //显式跳转
/*        Intent intent=new Intent(this, SimpleList.class);
        startActivity(intent);*/
    }
    public void toBase_list(View view){
/*        Intent intent=new Intent(this, Baselist.class);
        startActivity(intent);
        Log.d("base","成功跳转");*/

        //界面跳转的Intent隐式用法:经常用于不同软件之间的跳转，和系统应用之间的跳转
        ///第一种:同一软件之间的不同界面之间的跳转
        ///单纯以action匹配的只能匹配过滤器中没有data的数组件
        ////创建Intent
        Intent intent =new Intent();
        ////使用Action函数
        intent.setAction("TextActivity");
        intent.addCategory("android.intent.category.BaseList");
        ////开始跳转设置
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
        Log.i("Main","Base界面开始跳转");
    }

    public void choose_text(View view) {
/*        Intent intent=new Intent();
        //Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.bilibili.com/"));
        intent.setAction(Intent.ACTION_VIEW);
        //intent.setAction("Simple");
        //intent.addCategory("Simple");
       Uri uri=Uri.parse("https://www.baidu.com/");

        //intent.setAction("text");
        //intent.setData()
        //intent.setData(uri);
        //取消设置默认应用选项
        Intent rintent=Intent.createChooser(intent,"外部应用");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(rintent);
            Log.i("tag","success");

        }*/
        //创建意图
        Intent intent=new Intent();
        //设置跳转条件
        intent.setAction("TextActivity");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    public void result(View view) {
        Intent intent=new Intent(this,Calculate.class);
        intent.putExtra("name","张晓明");
        intent.putExtra("sex","男");
        startActivity(intent);
    }


    public void PacketDelivery(View view) {
/*        Intent intent=new Intent(this, BuddlePack.class);
        Bundle bundle=new Bundle();
        bundle.putString("姓名","独饮一名");
        bundle.putString("性别","women");
        intent.putExtras(bundle);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);

        }*/

        Intent intent=new Intent(MainActivity.this,BuddlePack.class);
        Bundle bundle=new Bundle();
        bundle.putString("年齡","18");
        bundle.putString("身高","170");
        intent.putExtras(bundle);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("tag", "开始经过函数");
        switch (requestCode){
            case 1:
                if (resultCode==2){
                    String returns=data.getStringExtra("返回");
                    Log.i("tag", "返回值调取成功");
                    Toast.makeText(this, "获取成功"+returns, Toast.LENGTH_SHORT).show();
                }

        }
    }

    public void ParameterCallback(View view) {
        Intent intent=new Intent(MainActivity.this,ParameterCallback.class);
        Bundle bundle=new Bundle();
        String arry[]={"1","2","3"};
        bundle.putString("地址",arry[0]);
        bundle.putString("新地址",arry[1]);
        bundle.putString("综合地址",arry[2]);
        intent.putExtras(bundle);
        Log.i("tag","经过函数");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivityForResult(intent,1);
        }
        Log.i("tag","经过打开界面判断");



    }

    @SuppressLint("QueryPermissionsNeeded")
    public void phone(View view) {
        //action+data
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        Uri uri=Uri.parse("10086");
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
            Log.i("tag", "phone: 电话打开成功");
        }
    }

    public void http(View view) {
        //action+data
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri=Uri.parse("https://www.bilibili.com");
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    public void send(View view) {
        //action+type
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("sms-list","发短信--短信内容");
        Log.i("tag", "Installation: 发送成功");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }


    }
    @SuppressLint("SdCardPath")
    public void music(View view) {
        //action+type+data
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
         Uri uri=Uri.parse("file:///sdcard/._baozilian.mp3");
        intent.setDataAndType(uri,"audio/mp3");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
    @SuppressLint("SdCardPath")
    public void Installation(View view) {
        //action+data+tye
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri=Uri.fromFile(new File("/sdcard/iqiyi_20236.apk"));
        Log.i("tag", "Installation: 安装成功");
        intent.setDataAndType(uri,"application/vnd.android.package-archive");//type中为固定内容
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    public void UnInstallation(View view) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri=Uri.parse("package:com.qiyi.video");
        Log.i("tag", "Installation: 卸载成功");
        intent.setData(uri);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    public void DefaultApp(View view) {
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Intent intent1=Intent.createChooser(intent,"外部应用");
        if (intent1.resolveActivity(getPackageManager())!=null){
            startActivity(intent1);
        }
    }
}