package com.example.lc.materialdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //布局文件
        getMenuInflater().inflate(R.menu.menuy, menu);

//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//
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
//        MenuItem add=menu.add(0,1,0,"ADD");
//        MenuItem del=menu.add(0,2,0,"DEL");
//        MenuItem save=menu.add(0,3,0,"SAVE");
//        //绑定到ActionBar
//        add.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//        del.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//        save.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
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
