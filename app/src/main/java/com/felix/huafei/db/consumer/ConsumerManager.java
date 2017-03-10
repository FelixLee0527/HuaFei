package com.felix.huafei.db.consumer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.felix.huafei.db.DBHelper;
import com.felix.huafei.db.DBManager;
import com.felix.huafei.modle.Consumer;
import com.felix.huafei.modle.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 2017/3/8.
 */

public class ConsumerManager
{
    private static DBManager instance;

    private DBHelper dbHelper;

    public ConsumerManager(Context context)
    {
        this.dbHelper = new DBHelper(context);
        DBManager.initializeInstance(dbHelper);
    }

    public void insertConsumer(Consumer consumer)
    {
        if(consumer == null || dbHelper == null)
        {
            return;
        }

        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        if(db == null)
        {
            return;
        }

        Log.d("ConsumerManager", "insertConsumer: " + consumer.getConsumerName());

        db.execSQL("insert into consumer(consumer_name,consumer_account, consumer_address ,cell_phone_number ," + "telephone_number,email_address,qq_number,remarks values(?,?,?,?,?,?,?,?)", new Object[]{consumer.getConsumerName() , consumer.getConsumerAccount() , consumer.getConsumerAddress() , consumer.getCellphoneNumber() , consumer.getTelephoneNumber() , consumer.getEmail_address() , consumer.getQqNumber() , consumer.getRemarks()});
        DBManager.getInstance().closeDatabase();
    }

    public List<Consumer> loadConsumerByAll()
    {
        String     queryByAll   = "select * from consumer order by title asc";
        List<Consumer> consumerList = new ArrayList<>();
        try
        {

            SQLiteDatabase db = DBManager.getInstance().openDatabase();

            Cursor cursor = db.rawQuery(queryByAll, new String[]{});

            while(cursor.moveToNext())
            {
                Consumer consumer = new Consumer();
                consumer.setConsumerName(cursor.getString(cursor.getColumnIndex("consumer_name")));
                consumer.setConsumerAccount(cursor.getString(cursor.getColumnIndex("consumer_account")));
                consumer.setConsumerAddress(cursor.getString(cursor.getColumnIndex("consumer_address")));
                consumer.setCellphoneNumber(cursor.getString(cursor.getColumnIndex("cell_phone_number")));
                consumer.setTelephoneNumber(cursor.getString(cursor.getColumnIndex("telephone_phone_number")));
                consumer.setEmail_address(cursor.getString(cursor.getColumnIndex("email_address")));
                consumer.setQqNumber(cursor.getString(cursor.getColumnIndex("qq_number")));
                consumer.setRemarks(cursor.getString(cursor.getColumnIndex("remarks")));
                consumerList.add(consumer);
            }
            cursor.close();
            DBManager.getInstance().closeDatabase();


        }
        catch(Exception e)
        {
            Log.e("ConsumerManager", "loadMusicList: " + e);
        }

        return consumerList;
    }

    public void updateConsumer(Consumer consumer)
    {
        if(consumer == null|| dbHelper == null)
        {
            return;
        }

        deleteConsumerById(consumer.getId());

        insertConsumer(consumer);
    }


    public void deleteConsumerById(int id)
    {
        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        db.execSQL("delete from consumer where id=?", new Object[]{id});
        DBManager.getInstance().closeDatabase();
    }

    public void deleteAll()
    {
        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        db.execSQL("delete from consumer", new Object[]{});
        DBManager.getInstance().closeDatabase();

    }

}
