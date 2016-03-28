package com.work.tommy.bearing_android_app;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.*;
import org.junit.runner.RunWith;


/**
 * Test the DBAdapter
 */
@RunWith(AndroidJUnit4.class)
public class DBAdapterTest {

    private static DBAdapter dbAdapter = null;
    private static String TAG = "TestingUnit->";


    @Before
    public void setUp(){
        Log.d(TAG, "setUp: called");
        dbAdapter = new DBAdapter(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void testTest() {
    assert(true);

    }
}