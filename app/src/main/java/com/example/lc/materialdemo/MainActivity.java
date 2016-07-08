package com.example.lc.materialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    GridView gv_demo_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gv_demo_list = (GridView)findViewById(R.id.gv_demo_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.add("ActionBar");
        adapter.add("CoordinatorLayout");
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
                }
                startActivity(intent);
            }
        });
    }
}
