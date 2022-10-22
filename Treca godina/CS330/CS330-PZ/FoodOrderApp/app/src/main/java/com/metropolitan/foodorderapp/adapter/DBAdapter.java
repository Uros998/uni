package com.metropolitan.foodorderapp.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

    static final String KEY_INDEX = "food_ordered_id";
    static final String KEY_NAME = "customer_name";
    static final String KEY_ADDRESS = "customer_address";
    static final String KEY_CITY = "customer_city";
    static final String KEY_STATE = "customer_state";
    static final String KEY_ZIP = "customer_zip";
    static final String KEY_CARD_NUMBER = "card_number";
    static final String KEY_CARD_EXPIRY = "card_expiry";
    static final String KEY_CARD_PIN = "card_pin";
    static final String KEY_TOTAL_ITEMS = "total_items";
    static final String KEY_SUBTOTAL = "subtotal";
    static final String KEY_DELIVERY_CHARGE = "delivery_charge";
    static final String KEY_TOTAL = "total";
    static final String TAG = "DBAdapter";

    static final String DATABASE_NAME = "foodOrderApp";
    static final String DATABASE_TABLE = "foodOrdered";
    static final int DATABASE_VERSION = 1;

    static final String DATABASE_CREATE =
            "create table foodOrdered (food_ordered_id integer primary key autoincrement, "
                    + "customer_name text not null, customer_address text, "
                    + "customer_city text, customer_state text, "
                    + "customer_zip number, card_number text not null, "
                    + "card_expiry number not null, card_pin number not null, "
                    + "total_items number not null, subtotal text not null, "
                    + "delivery_charge text, total text not null);";

    final Context context;

    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DBAdapter(Context ctx) {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG, "Ažuriranje verzije baze podataka sa " + oldVersion + " na verziju "
                    + newVersion + ", a to će uništiti postojeće podatke.");
            db.execSQL("DROP TABLE IF EXISTS foodOrdered;");
            onCreate(db);
        }
    }

    //---open() the db---
    public DBAdapter open() throws SQLException {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---close() the db---
    public void close() {
        DBHelper.close();
    }

    //---insert() food order in db---
    public long insertFoodOrder(String customer_name, String customer_address, String customer_city, String customer_state,
                                int customer_zip, String card_number, int card_expiry, int card_pin, int total_items,
                                String subtotal, String delivery_charge, String total) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, customer_name);
        initialValues.put(KEY_ADDRESS, customer_address);
        initialValues.put(KEY_CITY, customer_city);
        initialValues.put(KEY_STATE, customer_state);
        initialValues.put(KEY_ZIP, customer_zip);
        initialValues.put(KEY_CARD_NUMBER, card_number);
        initialValues.put(KEY_CARD_EXPIRY, card_expiry);
        initialValues.put(KEY_CARD_PIN, card_pin);
        initialValues.put(KEY_TOTAL_ITEMS, total_items);
        initialValues.put(KEY_SUBTOTAL, subtotal);
        initialValues.put(KEY_DELIVERY_CHARGE, delivery_charge);
        initialValues.put(KEY_TOTAL, total);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    //---findAll() food orders---
    public Cursor getAllFoodOrders() {
        return db.query(DATABASE_TABLE, new String[] {KEY_NAME, KEY_ADDRESS, KEY_CITY, KEY_STATE, KEY_ZIP, KEY_CARD_NUMBER,
                KEY_CARD_EXPIRY, KEY_CARD_PIN, KEY_TOTAL_ITEMS, KEY_SUBTOTAL, KEY_DELIVERY_CHARGE, KEY_TOTAL}, null, null, null, null, null);
    }

    //---findById() food ordered---
    public Cursor getFoodOrdered(long food_ordered_id) throws SQLException {
        Cursor mCursor =
                db.query(true, DATABASE_TABLE, new String[] {KEY_INDEX, KEY_NAME, KEY_ADDRESS, KEY_CITY, KEY_STATE, KEY_ZIP, KEY_CARD_NUMBER,
                                KEY_CARD_EXPIRY, KEY_CARD_PIN, KEY_TOTAL_ITEMS, KEY_SUBTOTAL, KEY_DELIVERY_CHARGE, KEY_TOTAL}, KEY_INDEX + "=" + food_ordered_id, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    //---deleteById() food ordered---
    public boolean deleteFoodOrdered(long food_ordered_id) {
        return db.delete(DATABASE_TABLE, KEY_INDEX + "=" + food_ordered_id, null) > 0;
    }

    public void clearDB() {
        db.execSQL("DROP TABLE IF EXISTS foodOrdered;");
        db.execSQL(DATABASE_CREATE);
    }

}