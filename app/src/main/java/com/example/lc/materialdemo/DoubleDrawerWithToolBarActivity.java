package com.example.lc.materialdemo;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 7/11/16
 */
public class DoubleDrawerWithToolBarActivity extends BaseActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    ActionBar actionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_drawer);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.inflateMenu(R.menu.menu_main);
//        toolbar.setOnMenuItemClickListener(onMenuItemClick);
//        toolbar.setTitle("标题");
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
//        mDrawerToggle.syncState();
//        mDrawerLayout.setDrawerListener(mDrawerToggle);

        initDrawer();
    }

    // 抽屉菜单对象
    private ActionBarDrawerToggle drawerbar;
    public DrawerLayout drawerLayout;
    private TestFragment testFragment;
    private RelativeLayout left_menu_layout, right_xiaoxi_layout;
    private TextView text;

    private void initDrawer() {
        initView();
        initEvent();
    }
    public void initView(){
        testFragment = new TestFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction f_transaction = fragmentManager.beginTransaction();
        f_transaction.replace(R.id.main_content_frame_parent, testFragment);
        f_transaction.commitAllowingStateLoss();
        initLeftLayout();
        initRightLayout();
    }
    public void initLeftLayout(){
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        //设置透明
        drawerLayout.setScrimColor(0x00000000);
        //左边菜单
        left_menu_layout = (RelativeLayout) findViewById(R.id.main_left_drawer_layout);
        View view2 = getLayoutInflater().inflate(R.layout.menu_left_layout, null);
        text=(TextView)view2.findViewById(R.id.text);
        text.setText("左边测试菜单");
        left_menu_layout.addView(view2);
    }
    public void initRightLayout(){
        //左边菜单
        right_xiaoxi_layout = (RelativeLayout) findViewById(R.id.main_right_drawer_layout);
        View view = getLayoutInflater().inflate(R.layout.menu_right_layout, null);
        text=(TextView)view.findViewById(R.id.text);
        text.setText("右边测试菜单");
        right_xiaoxi_layout.addView(view);
    }
    private void initEvent() {
        drawerbar = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.nav_icon_settings, R.string.drawer_open, R.string.drawer_close) {
            //菜单打开
            @Override
            public void onDrawerOpened(View drawerView) {

                super.onDrawerOpened(drawerView);
            }
            // 菜单关闭
            @Override
            public void onDrawerClosed(View drawerView) {

                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerbar);
    }
    //左边菜单开关事件
    public void openLeftLayout() {
        if (drawerLayout.isDrawerOpen(left_menu_layout)) {
            drawerLayout.closeDrawer(left_menu_layout);
        } else {
            drawerLayout.openDrawer(left_menu_layout);

        }
    }

    // 右边菜单开关事件
    public void openRightLayout() {
        if (drawerLayout.isDrawerOpen(right_xiaoxi_layout)) {
            drawerLayout.closeDrawer(right_xiaoxi_layout);
        } else {
            drawerLayout.openDrawer(right_xiaoxi_layout);
        }
    }


}
