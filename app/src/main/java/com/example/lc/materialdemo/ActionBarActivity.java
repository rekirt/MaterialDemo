package com.example.lc.materialdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class ActionBarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actionbar_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.e("test","bar==="+getSupportActionBar());
        TextView title = (TextView) toolbar.findViewById(R.id.tv_center_title);
        ActionBar bar = getSupportActionBar();
        baseSetting(bar,title);
//        findViewById(R.id.tv_custom).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(bar.isShowing())bar.hide();
//                else bar.show();
//            }
//        });

        //自定义actionbar
//        bar.setCustomView(R.layout.actionbar_layout);

//        ActionBar.LayoutParams lp =new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,ActionBar.LayoutParams.MATCH_PARENT,Gravity.CENTER);
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View titleView = inflater.inflate(R.layout.actionbar_layout, null);
//        bar.setCustomView(titleView, lp);
//
//        bar.setDisplayShowHomeEnabled(true);//去掉导航
//        bar.setDisplayShowTitleEnabled(false);//去掉标题
//        bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        bar.setDisplayShowCustomEnabled(true);

         //addDropDownList(bar);

        //actionbar支持tab,toolbar不支持tab
        //addTabList(bar);
    }

    private void addTabList(ActionBar bar) {
        bar.addTab(bar.newTab().setText("Tab1")
                .setTabListener(tabListener));
        bar.addTab(bar.newTab().setText("Tab2")
                .setTabListener(tabListener));
        bar.addTab(bar.newTab().setText("Tab3")
                .setTabListener(tabListener));
    }

    ActionBar.TabListener tabListener = new ActionBar.TabListener(){

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    };

    private void baseSetting(ActionBar bar,TextView title) {
        //        bar.setTitle("网易云音乐");
//        toolbar.setSubtitle("网易云音乐");
//        toolbar.setNavigationIcon(R.drawable.back);
        //返回按钮
        bar.setDisplayShowTitleEnabled(false);//隐藏标题
        bar.setDisplayHomeAsUpEnabled(true);//显示返回
        bar.setHomeButtonEnabled(true);
        bar.setDisplayShowHomeEnabled(true);
        bar.setDefaultDisplayHomeAsUpEnabled(true);
        title.setText("网易云音乐");
        //设置app图标
//        toolbar.setLogo(R.mipmap.ic_launcher);
//        toolbar.setDisplayUseLogoEnabled(true);
//        toolbar.setDisplayShowHomeEnabled(true);

        //设置背景颜色
//        bar.setBackgroundDrawable(new ColorDrawable(Color.RED));

        //显示隐藏,actionbar
//        bar.show();
//        bar.hide();
    }

    private void addDropDownList(ActionBar bar) {
        //下拉按钮,已过时
        //https://developer.android.com/design/patterns/navigation.html
        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.action_list,
                android.R.layout.simple_spinner_dropdown_item);
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);//导航模式必须设为NAVIGATION_MODE_LIST
        bar.setListNavigationCallbacks(mSpinnerAdapter,
                mOnNavigationListener);
    }

    //    private void initActionBar() {
//        actionBar=super.getActionBar();
//        actionBar.show();
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDisplayShowTitleEnabled(false);
//        actionBar.setDisplayHomeAsUpEnabled(true);
////        actionBar.setHomeAsUpIndicator(R.drawable.share_icon);
//        actionBar.setDisplayShowCustomEnabled(true);
//        TextView tvTitle=new TextView(this);
//        tvTitle.setText("主  页");
//        tvTitle.setTextColor(Color.WHITE);
//        tvTitle.setTextSize(18);
//        tvTitle.setGravity(Gravity.CENTER);
//        LayoutParams params=new  LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
//        tvTitle.setLayoutParams(params);
//        actionBar.setCustomView(tvTitle);
//    }

    ActionBar.OnNavigationListener mOnNavigationListener = new ActionBar.OnNavigationListener() {
        @Override
        public boolean onNavigationItemSelected(int position, long itemId) {
//            Fragment newFragment = null;
            switch (position) {
                case 0:
//                    newFragment = new Fragment1();
                    break;
                case 1:
//                    newFragment = new Fragment2();
                    break;
                case 2:
//                    newFragment = new Fragment3();
                    break;
                default:
                    break;
            }
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, newFragment, strings[position])
//                    .commit();
            return true;
        }
    };




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //xml方式添加
//        getMenuInflater().inflate(R.menu.menuy, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//        MenuItem shareItem = menu.findItem(R.id.action_share);
//        ShareActionProvider myShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
//        Intent myShareIntent = new Intent(Intent.ACTION_SEND);
//        myShareIntent.setType("image/*");
//        Uri myImageUri = Uri.fromFile(new File("/sdcard/image.png"));
//        myShareIntent.putExtra(Intent.EXTRA_STREAM, myImageUri);
//        myShareActionProvider.setShareIntent(myShareIntent);
//        myShareIntent.putExtra(Intent.EXTRA_STREAM, myNewImageUri);
//        myShareActionProvider.setShareIntent(myShareIntent);


        //代码添加
//        MenuItem add=menu.add(0,1,0,"设置");
//        MenuItem del=menu.add(0,2,0,"分享");
//        MenuItem save=menu.add(0,3,0,"搜索");
//         MenuItem other=menu.add(0,4,0,"其他");
        //绑定到ActionBar,setShowAsAction几个值的意思
        //always尽可能的显示，如果标题栏位置不够，则后面的不显示
        //never不显示在标题栏，只在弹出菜单中显示,即使一个菜单
        //ifRoom如果标题栏有足够的空间则显示，没有足够的空间则在弹出菜单中显示
        //如果actionbar有空间就完全显示，没有空间就用弹出popview多余的选项
//        add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//        del.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//        save.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//        other.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//        return true;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("test","id==="+item.getItemId());
        if(item.getItemId() == android.R.id.home)
        {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
