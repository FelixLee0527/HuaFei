package com.felix.huafei.db.order;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.felix.huafei.db.DBHelper;
import com.felix.huafei.db.DBManager;
import com.felix.huafei.modle.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 2017/3/8.
 */

public class OrderManager
{
    private static DBManager instance;

    private DBHelper dbHelper;

    public OrderManager(Context context)
    {
        this.dbHelper = new DBHelper(context);
        DBManager.initializeInstance(dbHelper);
    }

    public void insertOrder(Order order)
    {
        if(order == null || dbHelper == null)
        {
            return;
        }

        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        if(db == null)
        {
            return;
        }
        ContentValues values = new ContentValues();
        values.put("order_id", order.getOrderId());
        values.put("order_time", order.getOrderTime());
        values.put("consumer_id", order.getConsumerId());
        values.put("consumer_name", order.getConsumerName());
        values.put("money", order.getMoney());
        values.put("payment_status", order.getPaymentStatus());
        values.put("order_status", order.getOrderStatus());
        values.put("remarks", order.getRemarks());

        values.put("planting_area", order.getPlantingArea());
        values.put("planting_crops", order.getPlantingCrops());
        values.put("growth_stage", order.getGrowthStage());


        values.put("element1_price", order.getElement1Price());
        values.put("element2_price", order.getElement2Price());
        values.put("element3_price", order.getElement3Price());
        values.put("element4_price", order.getElement4Price());
        values.put("element5_price", order.getElement5Price());
        values.put("element6_price", order.getElement6Price());
        values.put("element7_price", order.getElement7Price());


        values.put("element1_weight", order.getElement1Weight());
        values.put("element2_weight", order.getElement2Weight());
        values.put("element3_weight", order.getElement3Weight());
        values.put("element4_weight", order.getElement4Weight());
        values.put("element5_weight", order.getElement5Weight());
        values.put("element6_weight", order.getElement6Weight());
        values.put("element7_weight", order.getElement7Weight());

        values.put("element1_volume", order.getElement1Volume());
        values.put("element2_volume", order.getElement2Volume());
        values.put("element3_volume", order.getElement3Volume());
        values.put("element4_volume", order.getElement4Volume());
        values.put("element5_volume", order.getElement5Volume());
        values.put("element6_volume", order.getElement6Volume());
        values.put("element7_volume", order.getElement7Volume());


        values.put("element1_price_subtotal", order.getElement1PriceSubtotal());
        values.put("element1_price_subtotal", order.getElement1PriceSubtotal());
        values.put("element2_price_subtotal", order.getElement2PriceSubtotal());
        values.put("element3_price_subtotal", order.getElement3PriceSubtotal());
        values.put("element4_price_subtotal", order.getElement4PriceSubtotal());
        values.put("element5_price_subtotal", order.getElement5PriceSubtotal());
        values.put("element6_price_subtotal", order.getElement6PriceSubtotal());
        values.put("element7_price_subtotal", order.getElement7PriceSubtotal());


        Log.d("OrderManager", "insertConsumer: " + order.getOrderId() + " " + order.getConsumerId() + " " + order.getConsumerName() + " " + order.getMoney() + " " + order.getPaymentStatus() + " " + order.getOrderStatus() + " " + order.getRemarks());
        db.insert("order_form", null, values);
        //        db.execSQL("insert into order(order_id,consumer_id,consumer_name,money,payment_status,order_status,remarks) values(?,?,?,?,?,?,?)", new Object[]{order.getOrderId() , order.getConsumerId() , order.getConsumerName() , order.getMoney() , order.getPaymentStatus() , order.getOrderStatus() , order.getRemarks()});
        DBManager.getInstance().closeDatabase();
    }

    public List<Order> loadOrderByAll()
    {
        String      queryByAll = "select * from order_form order by id asc";
        List<Order> orderList  = new ArrayList<>();
        try
        {

            SQLiteDatabase db = DBManager.getInstance().openDatabase();

            Cursor cursor = db.rawQuery(queryByAll, new String[]{});

            while(cursor.moveToNext())
            {
                Order order = new Order();
                order.setId(cursor.getInt(cursor.getColumnIndex("id")));
                order.setOrderId(cursor.getString(cursor.getColumnIndex("order_id")));
                order.setOrderTime(cursor.getString(cursor.getColumnIndex("order_time")));
                order.setConsumerId(cursor.getInt(cursor.getColumnIndex("consumer_id")));
                order.setConsumerName(cursor.getString(cursor.getColumnIndex("consumer_name")));
                order.setMoney(cursor.getDouble(cursor.getColumnIndex("money")));
                order.setPaymentStatus(cursor.getInt(cursor.getColumnIndex("payment_status")));
                order.setOrderStatus(cursor.getString(cursor.getColumnIndex("order_status")));
                order.setRemarks(cursor.getString(cursor.getColumnIndex("remarks")));

                order.setPlantingArea(cursor.getString(cursor.getColumnIndex("planting_area")));
                order.setPlantingCrops(cursor.getString(cursor.getColumnIndex("planting_crops")));
                order.setGrowthStage(cursor.getString(cursor.getColumnIndex("growth_stage")));

                order.setElement1Price(cursor.getFloat(cursor.getColumnIndex("element1_price")));
                order.setElement2Price(cursor.getFloat(cursor.getColumnIndex("element2_price")));
                order.setElement3Price(cursor.getFloat(cursor.getColumnIndex("element3_price")));
                order.setElement4Price(cursor.getFloat(cursor.getColumnIndex("element4_price")));
                order.setElement5Price(cursor.getFloat(cursor.getColumnIndex("element5_price")));
                order.setElement6Price(cursor.getFloat(cursor.getColumnIndex("element6_price")));
                order.setElement7Price(cursor.getFloat(cursor.getColumnIndex("element7_price")));

                order.setElement1Weight(cursor.getFloat(cursor.getColumnIndex("element1_weight")));
                order.setElement2Weight(cursor.getFloat(cursor.getColumnIndex("element2_weight")));
                order.setElement3Weight(cursor.getFloat(cursor.getColumnIndex("element3_weight")));
                order.setElement4Weight(cursor.getFloat(cursor.getColumnIndex("element4_weight")));
                order.setElement5Weight(cursor.getFloat(cursor.getColumnIndex("element5_weight")));
                order.setElement6Weight(cursor.getFloat(cursor.getColumnIndex("element6_weight")));
                order.setElement7Weight(cursor.getFloat(cursor.getColumnIndex("element7_weight")));

                order.setElement1Volume(cursor.getFloat(cursor.getColumnIndex("element1_volume")));
                order.setElement2Volume(cursor.getFloat(cursor.getColumnIndex("element2_volume")));
                order.setElement3Volume(cursor.getFloat(cursor.getColumnIndex("element3_volume")));
                order.setElement4Volume(cursor.getFloat(cursor.getColumnIndex("element4_volume")));
                order.setElement5Volume(cursor.getFloat(cursor.getColumnIndex("element5_volume")));
                order.setElement6Volume(cursor.getFloat(cursor.getColumnIndex("element6_volume")));
                order.setElement7Volume(cursor.getFloat(cursor.getColumnIndex("element7_volume")));

                order.setElement1PriceSubtotal(cursor.getFloat(cursor.getColumnIndex("element1_price_subtotal")));
                order.setElement2PriceSubtotal(cursor.getFloat(cursor.getColumnIndex("element2_price_subtotal")));
                order.setElement3PriceSubtotal(cursor.getFloat(cursor.getColumnIndex("element3_price_subtotal")));
                order.setElement4PriceSubtotal(cursor.getFloat(cursor.getColumnIndex("element4_price_subtotal")));
                order.setElement5PriceSubtotal(cursor.getFloat(cursor.getColumnIndex("element5_price_subtotal")));
                order.setElement6PriceSubtotal(cursor.getFloat(cursor.getColumnIndex("element6_price_subtotal")));
                order.setElement7PriceSubtotal(cursor.getFloat(cursor.getColumnIndex("element7_price_subtotal")));


                orderList.add(order);

            }
            cursor.close();
            DBManager.getInstance().closeDatabase();


        }
        catch(Exception e)
        {
            Log.e("ConsumerManager", "loadOrderByAll: " + e);
        }

        return orderList;
    }

    public void updateConsumer(Order order)
    {
        if(order == null || dbHelper == null)
        {
            return;
        }

        deleteConsumerById(order.getId());

        insertOrder(order);
    }


    public void deleteConsumerById(int id)
    {
        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        db.execSQL("delete from order_form where id=?", new Object[]{id});
        DBManager.getInstance().closeDatabase();
    }

    public void deleteAll()
    {
        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        db.execSQL("delete from order_form", new Object[]{});
        DBManager.getInstance().closeDatabase();

    }

}
