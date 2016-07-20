package com.example.lc.materialdemo;

import android.app.Application;
import android.app.Instrumentation;
import android.test.ApplicationTestCase;
import android.test.ViewAsserts;


/**
 * ApplicationTestCase中的泛型替换为自己的Application
 * 在没有调用createApplication之前getApplication返回null
 * getContext与getSystemContext返回的context一致
 * 在setUp中创建自己的Application
 *
 */
public class ApplicationTest extends ApplicationTestCase<MDApplication> {

    public ApplicationTest() {
        super(MDApplication.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
//        Logger.e("start1==="+getApplication()+"===="+getContext()+"===="+getSystemContext());
        createApplication();
//        Logger.e("start2==="+getApplication()+"===="+getContext()+"===="+getSystemContext());
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
//        Logger.e("stop");
    }

    public void testIntSave(){
        String key = "num";
        int num = 10;
//        SharedPreferencesUtil.getInstance().saveNum(key,num);
//        int result = SharedPreferencesUtil.getInstance().getNum(key);
//        Logger.e("===="+result);
//        assertEquals(num,result);
    }

    public void testActivity(){
//        ViewAsserts
//        MoreAsserts
    }
}