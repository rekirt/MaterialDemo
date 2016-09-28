package com.example.lc.materialdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lc.materialdemo.fancyflow.FancyCoverFlowSampleAdapter;

import at.technikum.mti.fancycoverflow.FancyCoverFlow;
import butterknife.InjectView;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-9-12
 */
public class FancyCoverFlowActivity extends BaseActivity {

    @InjectView(R.id.fancyCoverFlow)
    FancyCoverFlow fancyCoverFlow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fancycoverflow);
        this.fancyCoverFlow.setAdapter(new FancyCoverFlowSampleAdapter());
        this.fancyCoverFlow.setUnselectedAlpha(1.0f);
        this.fancyCoverFlow.setUnselectedSaturation(0.1f);
        this.fancyCoverFlow.setUnselectedScale(0.5f);
        this.fancyCoverFlow.setSpacing(10);
        this.fancyCoverFlow.setMaxRotation(0);
        this.fancyCoverFlow.setScaleDownGravity(1.8f);
        this.fancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
    }
}
