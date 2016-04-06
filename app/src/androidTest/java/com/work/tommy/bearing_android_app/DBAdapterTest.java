package com.work.tommy.bearing_android_app;

import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import static org.assertj.core.api.Assertions.*;

import android.util.Log;

import junit.framework.*;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Test the DBAdapter
 */
@RunWith(AndroidJUnit4.class)
public class DBAdapterTest {

    // reference to database adapter
    private static DBAdapter dbAdapter = null;
    // logging Tag string
    private static String TAG = "DBAdapterTest->";


    // run before every test function
    @Before
    public void setUp() throws Exception {
        Log.d(TAG, "setup: called");
        dbAdapter = new DBAdapter(InstrumentationRegistry.getTargetContext());
        assertThat(dbAdapter).isInstanceOf(DBAdapter.class);
        // open database
        dbAdapter.open();
    }

    // run after every test function
    @After
    public void tearDown() throws Exception {
        Log.d(TAG, "tearDown: called");
        if (dbAdapter != null) {
            // delete all records and close database
            dbAdapter.deleteAll();
            dbAdapter.close();
            dbAdapter = null;
        }
    }

    @Test
    public void test_dbAdapter_IsInstanceOf_DBAdapter_Class() throws Exception {
        assertThat(dbAdapter).isInstanceOf(DBAdapter.class);
    }

    @Test
    public void test_dbAdapter_Is_Empty() throws Exception {
        Cursor cursor = dbAdapter.getAllRows();
        Boolean result = cursor.moveToFirst();
        assertThat(result).isEqualTo(false);
        assertThat(cursor.getCount()).isEqualTo(0);
    }

    @Test
    public void test_dbAdapter_Insert_Record() throws Exception {
        InsertOneRecord_InTo_Database();
        Cursor cursor = dbAdapter.getAllRows();
        // check one record is saved
        assertThat(cursor.getCount()).isEqualTo(1);

    }

    @Test
    public void test_dbAdapter_ColumnNames_are_correct() throws Exception {
        Cursor cursor = dbAdapter.getAllRows();
        String[] columnNamesList = cursor.getColumnNames();
        assertThat(columnNamesList.length).isEqualTo(9);
        assertThat(cursor.getColumnCount()).isEqualTo(9);
        assertThat(columnNamesList[DBAdapter.COL_ROW_ID]).isEqualTo(DBAdapter.KEY_ROW_ID);
        assertThat(columnNamesList[DBAdapter.COL_BEARING_NUMBER]).isEqualTo(DBAdapter.KEY_BEARING_NUMBER);
        assertThat(columnNamesList[DBAdapter.COL_OD_SIZE]).isEqualTo(DBAdapter.KEY_OD_SIZE);
        assertThat(columnNamesList[DBAdapter.COL_ID_SIZE]).isEqualTo(DBAdapter.KEY_ID_SIZE);
        assertThat(columnNamesList[DBAdapter.COL_KEY_WIDTH]).isEqualTo(DBAdapter.KEY_WIDTH);
        assertThat(columnNamesList[DBAdapter.COL_KEY_TYPE]).isEqualTo(DBAdapter.KEY_TYPE);
        assertThat(columnNamesList[DBAdapter.COL_KEY_IMAGE_NUMBER]).isEqualTo(DBAdapter.KEY_IMAGE_NUMBER);
        assertThat(columnNamesList[DBAdapter.COL_KEY_LOCATION]).isEqualTo(DBAdapter.KEY_LOCATION);
        assertThat(columnNamesList[DBAdapter.COL_KEY_COMMENTS]).isEqualTo(DBAdapter.KEY_COMMENTS);
    }

    @Test
    public void test_dbAdapter_Data_Is_Correct() throws Exception {
        InsertOneRecord_InTo_Database();
        Cursor cursor = dbAdapter.getAllRows();
        // test database data is the same as the input data
        assertThat(cursor.getString(1)).isEqualTo("6200");
        assertThat(cursor.getInt(2)).isEqualTo(20);
        assertThat(cursor.getInt(3)).isEqualTo(12);
        assertThat(cursor.getInt(4)).isEqualTo(6);
        assertThat(cursor.getString(5)).isEqualTo("zz");
        assertThat(cursor.getInt(6)).isEqualTo(1);
        assertThat(cursor.getString(7)).isEqualTo("Workshop Stores");
        assertThat(cursor.getString(8)).isEqualTo("comments of the bearing go in here");
    }

    @Test
    public void test_dbAdapter_ALLKEYS_for_correct_sequence() throws Exception {

        assertThat(DBAdapter.ALL_KEYS[0]).isEqualTo(DBAdapter.KEY_ROW_ID);
        assertThat(DBAdapter.ALL_KEYS[1]).isEqualTo(DBAdapter.KEY_BEARING_NUMBER);
        assertThat(DBAdapter.ALL_KEYS[2]).isEqualTo(DBAdapter.KEY_OD_SIZE);
        assertThat(DBAdapter.ALL_KEYS[3]).isEqualTo(DBAdapter.KEY_ID_SIZE);
        assertThat(DBAdapter.ALL_KEYS[4]).isEqualTo(DBAdapter.KEY_WIDTH);
        assertThat(DBAdapter.ALL_KEYS[5]).isEqualTo(DBAdapter.KEY_TYPE);
        assertThat(DBAdapter.ALL_KEYS[6]).isEqualTo(DBAdapter.KEY_IMAGE_NUMBER);
        assertThat(DBAdapter.ALL_KEYS[7]).isEqualTo(DBAdapter.KEY_LOCATION);
        assertThat(DBAdapter.ALL_KEYS[8]).isEqualTo(DBAdapter.KEY_COMMENTS);


    }


    private void InsertOneRecord_InTo_Database() {
        dbAdapter.insertRow("6200", 20, 12, 6, "zz", 1, "Workshop Stores", "comments of the bearing go in here");
    }
}