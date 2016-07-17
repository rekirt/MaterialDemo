package com.example.lc.materialdemo.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lc.materialdemo.BaseActivity;
import com.example.lc.materialdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 7/11/16
 */
public class RecyclerViewActivity1 extends BaseActivity {

    RecyclerView mRecyclerView;
    private List<String> mDatas;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclyerview1);
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("RecyclerView1");

        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }

        initView();

    }

    private void initView() {
        mRecyclerView  = (RecyclerView) findViewById(R.id.rv_view);
//        LinearLayoutManager 现行管理器，支持横向、纵向。
//        GridLayoutManager 网格布局管理器
//        StaggeredGridLayoutManager 瀑布就式布局管理器

        //createListView();

        //createGridView();

        createStaggeredGridLayout();


        //添加移除动画
        //https://github.com/gabrielemariotti/RecyclerViewItemAnimators
    }

    private void createStaggeredGridLayout() {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(new StaggeredHomeAdapter(this,mDatas));
    }

    private void createGridView() {
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
    }

    private void createListView() {
        //LinearLayoutManager.HORIZONTAL水平listview，VERTICAL垂直listview
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true));
        //添加分割线,分割线必须与listview的方向一致,VERTICAL的布局对应VERTICAL_LIST的分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
    }


    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(RecyclerViewActivity1.this).inflate(R.layout.item_recyclyer_view, parent,
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
