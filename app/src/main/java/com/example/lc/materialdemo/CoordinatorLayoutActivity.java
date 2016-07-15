package com.example.lc.materialdemo;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CoordinatorLayoutActivity extends BaseActivity {


    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private ListView view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout);
//        actionbar();
        toolbar();
        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件

                            }
                        })
                        .show();
            }
        });

        tablayout_viewpager();

    }

    private void toolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("网易新闻");
    }

    private void tablayout_viewpager() {

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        for(int i = 0;i<100;i++)adapter.add("xxx"+i);
        view1 = new ListView(this);
        view2 = new ListView(this);
        view3 = new ListView(this);
        view4 = new ListView(this);
        view5 = new ListView(this);

        view1.setAdapter(adapter);
        view2.setAdapter(adapter);
        view3.setAdapter(adapter);
        view4.setAdapter(adapter);
        view5.setAdapter(adapter);

        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        mViewList.add(view4);
        mViewList.add(view5);

        //添加页卡标题
        mTitleList.add("No1");
        mTitleList.add("No2");
        mTitleList.add("No3");
        mTitleList.add("No4");
        mTitleList.add("No5");


        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(3)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(4)));

        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
//        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
    }

    //ViewPager适配器
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }








    private void actionbar() {

        android.app.ActionBar ab = getActionBar();
        final ActionBar bar = getSupportActionBar();
        Log.e("test",ab+"==bar==="+bar);
        bar.setTitle("网易云音乐");
        //返回按钮
        bar.setDisplayHomeAsUpEnabled(true);
//        bar.setHomeButtonEnabled(true);
//        bar.setDisplayShowHomeEnabled(true);
//        bar.setDefaultDisplayHomeAsUpEnabled(true);

        //设置app图标
        bar.setLogo(R.mipmap.ic_launcher);
        bar.setDisplayUseLogoEnabled(true);
        bar.setDisplayShowHomeEnabled(true);

        //设置背景颜色
//        bar.setBackgroundDrawable(new ColorDrawable(Color.RED));

        //显示隐藏,actionbar
//        bar.show();
        bar.hide();
    }

}
