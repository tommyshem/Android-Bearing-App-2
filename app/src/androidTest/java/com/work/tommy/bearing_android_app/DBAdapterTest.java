package com.work.tommy.bearing_android_app;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import static org.assertj.core.api.Assertions.*;
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
    public void setUp() throws Exception{
        Log.d(TAG, "BeforeClass: called");
        dbAdapter = new DBAdapter(InstrumentationRegistry.getTargetContext());
        assertThat(dbAdapter).isInstanceOf(DBAdapter.class);
    }

    @After
    public void tearDown() throws Exception{
        if (dbAdapter!=null){dbAdapter.close();}
    }

    @Test
    public void testTest() throws Exception{
    assert(true);

    }


}