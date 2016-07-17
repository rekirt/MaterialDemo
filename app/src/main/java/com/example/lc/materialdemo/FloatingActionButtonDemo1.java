package com.example.lc.materialdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.InjectView;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-17
 *
 *
 */
public class FloatingActionButtonDemo1 extends BaseActivity {

//    app:fabSize ：FloatingActionButton的大小，有两种赋值分别是 “mini” 和 “normal”，默认是“normal”.
//    app:backgroundTint：FloatingActionButton默认正常显示时的背景颜色
//    app:elevation ：FloatingActionButton阴影的深度，默认时的阴影
//    app:rippleColor：FloatingActionButton点击时的背景颜色
//    app:pressedTranslationZ：FloatingActionButton点击时阴影的深度

    @InjectView(R.id.fab)
    FloatingActionButton fab;

    @InjectView(R.id.rv_view)
    RecyclerView rv_view;
    private List<String> mDatas;
    private HomeAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floatingactionbutton);
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }

        initfab();
        initRecycleView();
    }

    private void initRecycleView() {
        rv_view.setLayoutManager(new LinearLayoutManager(this));
        rv_view.setAdapter(mAdapter = new HomeAdapter());
    }

    //https://github.com/Clans/FloatingActionButton
    private void initfab() {

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件
                            }
                        }).show();
            }
        });


    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(FloatingActionButtonDemo1.this).inflate(R.layout.item_recyclyer_view, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position){
            holder.tv.setText(mDatas.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    return false;
                }
            });
        }

        @Override
        public int getItemCount(){
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView tv;
            public MyViewHolder(View view){
                super(view);
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
