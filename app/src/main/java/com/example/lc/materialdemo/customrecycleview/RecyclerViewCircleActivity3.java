package com.example.lc.materialdemo.customrecycleview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lc.materialdemo.R;
import com.example.lc.materialdemo.utils.ScreenUtil;

public class RecyclerViewCircleActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview_circle);
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycler);
        ScrollZoomLayoutManager scrollZoomLayoutManager = new ScrollZoomLayoutManager(this,Dp2px(10));
        recyclerView.addOnScrollListener(new CenterScrollListener());
        recyclerView.setLayoutManager(scrollZoomLayoutManager);
        recyclerView.setAdapter(new Adapter());

    }

    public int Dp2px(float dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(RecyclerViewCircleActivity3.this).inflate(R.layout.item_course_detail_class_layout,parent,false);
            int w = ScreenUtil.getScreenWidth(RecyclerViewCircleActivity3.this);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(w / 4, w / 3);
            v.setLayoutParams(params);
            MyViewHolder holder = new MyViewHolder(v);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((MyViewHolder)holder).ll_content.setText("第"+position+"讲");
        }

        @Override
        public int getItemCount() {
            return 200;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            TextView ll_content;
            public MyViewHolder(View itemView){
                super(itemView);
                ll_content = (TextView) itemView.findViewById(R.id.ll_content);
            }
        }
    }
}
