package com.felix.huafei.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by felix on 2017/3/8.
 */

public class DBHelper extends SQLiteOpenHelper
{
    private final static int    DATABASE_VERSION = 1;
    private final static String DATABASE_NAME    = "HuaFei.db";

    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String table_user = "CREATE TABLE IF NOT EXISTS user (\n" +
                "  id integer PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "  user_name text(128) NOT NULL,\n" +
                "  password text(128),\n" +
                "  email text(128),\n" +
                "  cell_phone_number text(128),\n" +
                "  telephone_phone_number text(128)\n" +
                ");";

        db.execSQL(table_user);

        String table_consumer = "CREATE TABLE IF NOT EXISTS consumer (\n" +
                "  id integer PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "  consumer_name text(128) NOT NULL,\n" +
                "  consumer_account text(128),\n" +
                "  consumer_address text(256),\n" +
                "  cell_phone_number text(128),\n" +
                "  telephone_number text(128),\n" +
                "  email_address text(128),\n" +
                "  qq_number text(128),\n" +
                "  remarks text(1024)\n" +
                ");";

        db.execSQL(table_consumer);
//
//        "CREATE TABLE IF NOT EXISTS \"order_form\" (\n" +
//                "  id integer PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
//                "  order_id text NOT NULL,\n" +
//                "  order_time text NOT NULL,\n" +
//                "  consumer_id integer NOT NULL,\n" +
//                "  consumer_name text NOT NULL,\n" +
//                "  money double NOT NULL,\n" +
//                "  payment_status integer NOT NULL,\n" +
//                "  order_status text NOT NULL,\n" +
//                "  remarks text NOT NULL\n" +
//                ");"
        String table_order = "CREATE TABLE IF NOT EXISTS order_form (\n" +
                "  id integer PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                "  order_id text NOT NULL,\n" +
                "  order_time text,\n" +
                "  consumer_id integer NOT NULL,\n" +
                "  consumer_name text NOT NULL,\n" +
                "  money double NOT NULL,\n" +
                "  payment_status integer NOT NULL,\n" +
                "  order_status text NOT NULL,\n" +
                "  remarks text NOT NULL,\n" +
                "  planting_area text,\n" +
                "  planting_crops text,\n" +
                "  growth_stage text,\n" +
                "  element1_price float,\n" +
                "  element2_price float,\n" +
                "  element3_price float,\n" +
                "  element4_price float,\n" +
                "  element5_price float,\n" +
                "  element6_price float,\n" +
                "  element7_price float,\n" +
                "  element1_weight float,\n" +
                "  element2_weight float,\n" +
                "  element3_weight float,\n" +
                "  element4_weight float,\n" +
                "  element5_weight float,\n" +
                "  element6_weight float,\n" +
                "  element7_weight float,\n" +
                "  element1_volume float,\n" +
                "  element2_volume float,\n" +
                "  element3_volume float,\n" +
                "  element4_volume float,\n" +
                "  element5_volume float,\n" +
                "  element6_volume float,\n" +
                "  element7_volume float,\n" +
                "  element1_price_subtotal float,\n" +
                "  element2_price_subtotal float,\n" +
                "  element3_price_subtotal float,\n" +
                "  element4_price_subtotal float,\n" +
                "  element5_price_subtotal float,\n" +
                "  element6_price_subtotal float,\n" +
                "  element7_price_subtotal float,\n" +
                "  FOREIGN KEY (consumer_id, consumer_name) REFERENCES consumer (id, consumer_name)\n" +
                ");";

        db.execSQL(table_order);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {


    }
}
