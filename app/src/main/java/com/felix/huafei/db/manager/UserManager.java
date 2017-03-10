package com.felix.huafei.db.manager;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.felix.huafei.db.DBHelper;
import com.felix.huafei.db.DBManager;
import com.felix.huafei.modle.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by felix on 2017/3/8.
 */

public class UserManager
{

    private DBHelper dbHelper;

    public UserManager(Context context)
    {
        this.dbHelper = new DBHelper(context);
        DBManager.initializeInstance(dbHelper);
    }

    public void insertUser(User user)
    {
        if(user == null || dbHelper == null)
        {
            return;
        }

        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        if(db == null)
        {
            return;
        }

        Log.d("UserManager", "insertUser: " + user.getUserName());

        db.execSQL("insert into user(user_name,password, email ,cell_phone_number ,telephone_phone_number) values(?,?,?,?,?)", new Object[]{user.getUserName() , user.getPassword() , user.getEmail() , user.getCellphoneNumber() , user.getTelephoneNumber()});
        DBManager.getInstance().closeDatabase();
    }

    public List<User> loadUserByAll()
    {
        String     queryByAll = "select * from user order by title asc";
        List<User> userList   = new ArrayList<>();
        try
        {

            SQLiteDatabase db = DBManager.getInstance().openDatabase();

            Cursor cursor = db.rawQuery(queryByAll, new String[]{});

            while(cursor.moveToNext())
            {
                User user = new User();
                user.setUserName(cursor.getString(cursor.getColumnIndex("user_name")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                user.setEmail(cursor.getString(cursor.getColumnIndex("email")));
                user.setCellphoneNumber(cursor.getString(cursor.getColumnIndex("cell_phone_number")));
                user.setTelephoneNumber(cursor.getString(cursor.getColumnIndex("telephone_phone_number")));
                userList.add(user);
            }
            cursor.close();
            DBManager.getInstance().closeDatabase();


        }
        catch(Exception e)
        {
            Log.e("UserManager", "loadMusicList: " + e);
        }

        return userList;
    }

    public void updateUser(User user)
    {
        if(user == null|| dbHelper == null)
        {
            return;
        }

        deleteUserById(user.getId());

        insertUser(user);
    }


    public void deleteUserById(int id)
    {
        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        db.execSQL("delete from user where id=?", new Object[]{id});
        DBManager.getInstance().closeDatabase();
    }

    public void deleteAll()
    {

        SQLiteDatabase db = DBManager.getInstance().openDatabase();
        db.execSQL("delete from user", new Object[]{});
        DBManager.getInstance().closeDatabase();

    }

}
