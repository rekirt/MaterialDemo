package com.example.lc.materialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.example.lc.materialdemo.palette.ToolBarPaletteActivity;
import com.example.lc.materialdemo.recyclerview.RecyclerViewActivity1;

public class MainActivity extends BaseActivity {

    ListView gv_demo_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv_demo_list = (ListView)findViewById(R.id.gv_demo_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("ActionBar");
        adapter.add("CoordinatorLayout");
        adapter.add("Drawer1");
        adapter.add("Drawer2");
        adapter.add("DoubleDrawer1");
        adapter.add("DoubleDrawer2");
        adapter.add("Palette");
        adapter.add("RecyclerView");
        adapter.add("FloatingActionButton");
        gv_demo_list.setAdapter(adapter);

        gv_demo_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(getBaseContext(),ActionBarActivity.class);
                        break;
                    case 1:
                        intent = new Intent(getBaseContext(),CoordinatorLayoutActivity.class);
                        break;
                    case 2:
                        intent = new Intent(getBaseContext(),DrawerWithToolBarActivity1.class);
                        break;
                    case 3:
                        intent = new Intent(getBaseContext(),DrawerWithToolBarActivity2.class);
                        break;
                    case 4:
                        intent = new Intent(getBaseContext(),DoubleDrawerWithToolBarActivity.class);
                        break;
                    case 5:
                        intent = new Intent(getBaseContext(),DoubleDrawerWithToolBarActivity2.class);
                        break;
                    case 6:
                        intent = new Intent(getBaseContext(),ToolBarPaletteActivity.class);
                        break;
                    case 7:
                        intent = new Intent(getBaseContext(),RecyclerViewActivity1.class);
                        break;
                    case 8:
                        intent = new Intent(getBaseContext(),FloatingActionButtonDemo1.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}
