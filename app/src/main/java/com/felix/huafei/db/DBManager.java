package com.felix.huafei.db;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by felix on 2017/3/8.
 */
public class DBManager
{
    private AtomicInteger mOpenCounter = new AtomicInteger();

    private static DBManager        instance;
    private static SQLiteOpenHelper mDatabaseHelper;

    private SQLiteDatabase mDatabase;

    public static synchronized void initializeInstance(SQLiteOpenHelper helper)
    {
        if(instance == null)
        {
            instance = new DBManager();
            mDatabaseHelper = helper;
        }
    }

    public static synchronized DBManager getInstance()
    {
        if(instance == null)
        {
            throw new IllegalStateException(DBManager.class.getSimpleName() + " is not initialized, call initializeInstance(..) method first.");
        }

        return instance;
    }

    public synchronized SQLiteDatabase openDatabase()
    {
        if(mOpenCounter.incrementAndGet() == 1)
        {
            // Opening new database
            mDatabase = mDatabaseHelper.getWritableDatabase();
        }
        return mDatabase;
    }

    public synchronized void closeDatabase()
    {
        if(mOpenCounter.decrementAndGet() == 0)
        {
            // Closing database
            mDatabase.close();
        }
    }
}
