package com.example.lc.materialdemo;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import java.lang.reflect.Method;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 7/11/16
 */
public class DoubleDrawerWithToolBarActivity2 extends BaseActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private View right_sliding;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_double_drawer2);
        initActionBar();
        initDrawerLayout();
    }

    private void initActionBar(){
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        actionBar= getSupportActionBar();
        actionBar.show();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.com_btn);
        Drawable colorDrawable=new ColorDrawable(0);
        actionBar.setIcon(colorDrawable);
        actionBar.setDisplayShowCustomEnabled(true);
        TextView tvTitle=new TextView(this);
        tvTitle.setText("水电费");
        tvTitle.setTextColor(Color.WHITE);
        tvTitle.setTextSize(18);
        tvTitle.setGravity(Gravity.CENTER);
        LayoutParams params=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
        tvTitle.setLayoutParams(params);
        actionBar.setCustomView(tvTitle);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_slidemenu, menu);
        return true;
    }
    private void initDrawerLayout(){
        drawerLayout=(DrawerLayout)super.findViewById(R.id.drawer_layout);
        drawerLayout.setScrimColor(Color.TRANSPARENT);
        right_sliding=super.findViewById(R.id.right_sliding);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,
                R.drawable.back_move_details_normal,R.string.drawer_open
                ,R.string.drawer_close){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

        };
        drawerLayout.setDrawerListener(toggle);
        //drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        //drawerLayout.openDrawer(right_sliding);


    }

    private void toggleLeftSliding(){
        if(drawerLayout.isDrawerOpen(Gravity.START)){
            drawerLayout.closeDrawer(Gravity.START);
        }else{
            drawerLayout.openDrawer(Gravity.START);
        }
    }
    private void toggleRightSliding(){
        if(drawerLayout.isDrawerOpen(Gravity.END)){
            drawerLayout.closeDrawer(Gravity.END);
        }else{
            drawerLayout.openDrawer(Gravity.END);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                toggleLeftSliding();
                break;
            case R.id.usersetting:
                toggleRightSliding();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if (featureId == Window.FEATURE_ACTION_BAR && menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                }
            }
        }
        return super.onMenuOpened(featureId, menu);
    }


}
