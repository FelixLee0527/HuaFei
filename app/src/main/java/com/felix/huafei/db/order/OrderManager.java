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

        values.put("Nitrogenous_price", order.getNitrogenousPrice());
        values.put("Phosphorus_price", order.getPhosphorusPrice());
        values.put("Kalium_price", order.getKaliumPrice());

        values.put("Nitrogenous_weight", order.getNitrogenousWeight());
        values.put("Phosphorus_weight", order.getPhosphorusWeight());
        values.put("Kalium_weight", order.getKaliumWeight());

        values.put("Nitrogenous_price_subtotal", order.getNitrogenousPriceSubtotal());
        values.put("Phosphorus_price_subtotal", order.getPhosphorusPriceSubtotal());
        values.put("Kalium_price_subtotal", order.getKaliumPriceSubtotal());


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

                order.setNitrogenousPrice(cursor.getFloat(cursor.getColumnIndex("Nitrogenous_price")));
                order.setPhosphorusPrice(cursor.getFloat(cursor.getColumnIndex("Phosphorus_price")));
                order.setKaliumPrice(cursor.getFloat(cursor.getColumnIndex("Kalium_price")));

                order.setNitrogenousWeight(cursor.getFloat(cursor.getColumnIndex("Nitrogenous_weight")));
                order.setPhosphorusWeight(cursor.getFloat(cursor.getColumnIndex("Phosphorus_weight")));
                order.setKaliumWeight(cursor.getFloat(cursor.getColumnIndex("Kalium_weight")));

                order.setNitrogenousPriceSubtotal(cursor.getFloat(cursor.getColumnIndex("Nitrogenous_price_subtotal")));
                order.setPhosphorusPriceSubtotal(cursor.getFloat(cursor.getColumnIndex("Phosphorus_price_subtotal")));
                order.setKaliumPriceSubtotal(cursor.getFloat(cursor.getColumnIndex("Kalium_price_subtotal")));


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
