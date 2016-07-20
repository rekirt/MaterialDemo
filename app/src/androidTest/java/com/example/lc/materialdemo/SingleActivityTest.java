package com.example.lc.materialdemo;

import android.app.Activity;
import android.support.annotation.WorkerThread;
import android.test.ActivityInstrumentationTestCase2;
import android.test.SingleLaunchActivityTestCase;
import android.test.UiThreadTest;
import android.widget.TextView;


/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 7/20/16
 * activyt测试
 */
public class SingleActivityTest extends SingleLaunchActivityTestCase<Activity> {

    public SingleActivityTest(String pkg, Class<Activity> activityClass) {
        super(pkg, activityClass);
    }

    public void testSetText() throws Exception {
        Activity activity = getActivity();
        // search for the textView
        final TextView textView = (TextView) activity.findViewById(0);
        // set text
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText("hello");
            }
        });
        getInstrumentation().waitForIdleSync();
        assertEquals("Text incorrect", "hello", textView.getText().toString());
    }

    @UiThreadTest
    public void testSetTextWithAnnotation() throws Exception {
        Activity activity = getActivity();
        // search for the textView
        final TextView textView = (TextView) activity.findViewById(0);
        textView.setText("world");
        assertEquals("Text incorrect", "world", textView.getText().toString());

    }
}
