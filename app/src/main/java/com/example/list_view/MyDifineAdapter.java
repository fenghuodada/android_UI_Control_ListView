package com.example.list_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyDifineAdapter extends BaseAdapter {

    //创建上下文
    private Context context;
    //创建数据源
    private List<Item> datas;
    //引用条目布局
    LayoutInflater layoutInflater;

    //创建构造器，目的初始数据源和控件;也就是把数据传，进来；
    public MyDifineAdapter(List<Item> idatas, Context icontext){
        //初始化/实例化变量content
        this.context=icontext;
        //初始化/实例化变量dates
        this.datas=idatas;
        //实例化对象layoutInflater
        layoutInflater=LayoutInflater.from(context);
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView_1,textView_2;
    }
    //返回条目个数
    @Override
    public int getCount() {
        return datas.size();
    }
    //返回对象
    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }
    //返回位置
    @Override
    public long getItemId(int position) {
        return position;
    }
//返回条目view
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //回收的是数据和视图，如果不想让视图消失，则创建一个可以存放视图的地方，下次直接填充内容，这个空间类就是ViewHolder,存储的是视图的信息，而不是数据的信息；
        //对手机屏幕也就是ViewGroup中的item布局控件进行检测是否为零，只要这组中有空的视图空间就接着创建，如果没了，就引用
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            //调用viewGroup中item布局
            convertView=layoutInflater.inflate(R.layout.activity_simple_list,viewGroup,false);
            //声明并实例化条目布局中的控件
            ImageView imageView =convertView.findViewById(R.id.image);
            TextView textView_1=convertView.findViewById(R.id.text_view_1);
            TextView textView_2=convertView.findViewById(R.id.text_view_2);
            //把控件拷入到holder一份，用于后来再次重复利用的时候拿取
             viewHolder.imageView =imageView;
             viewHolder.textView_1=textView_1;
             viewHolder.textView_2=textView_2;
             //对条目布局控件添加附加信息，添加有一个储存条目布局控件的位置，以便于直接使用、
             convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }

            //寻找某一具体数据源条目位置
            Item item=datas.get(position);
            //填充数据，对布局中的控件的内容进行修改
            viewHolder.imageView.setImageResource(item.getImagesid());
            viewHolder.textView_1.setText(item.getTitle());
            viewHolder.textView_2.setText(item.getEssay());
            //返回布局

        return convertView ;
    }
}
