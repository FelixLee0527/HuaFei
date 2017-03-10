package com.felix.huafei.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.felix.huafei.R;
import com.felix.huafei.db.consumer.ConsumerManager;
import com.felix.huafei.db.manager.UserManager;
import com.felix.huafei.db.order.OrderManager;
import com.felix.huafei.modle.Order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by felix on 2017/3/7.
 */

public class MainActivity extends AppCompatActivity
{
    @BindView(R.id.tv_main)           TextView tvMain;
    @BindView(R.id.btn_order_manager) Button   btnOrderManager;

    private UserManager     userManager;
    private ConsumerManager consumerManager;
    private OrderManager    orderManager;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        userManager = new UserManager(this);
        consumerManager = new ConsumerManager(this);
        orderManager = new OrderManager(this);

    }

    //    @OnClick({R.id.tv_main,R.id.btn_order_manager})
    //    public void onClick()
    //    {
    //
    //    }


    public void initData()
    {
        Order order = new Order();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


        for(int i = 0; i < 10; i++)
        {
            Random random  = new Random();
            int    randNum = random.nextInt(80000000) + 10000000;


            order.setOrderId(String.valueOf(randNum));
            order.setConsumerName("张三");
            order.setConsumerId(random.nextInt(100));
            order.setPaymentStatus(random.nextInt(2));
            order.setOrderStatus("已完成");
            order.setMoney(random.nextDouble() + 1000);
            order.setRemarks("无");
            order.setOrderTime(df.format(new Date()));

            order.setPlantingArea(String.valueOf(random.nextInt(100))+"/亩");
            order.setPlantingCrops("水稻");
            order.setGrowthStage("秧苗期");

            order.setPhosphorusPrice(5.0f);
            order.setNitrogenousPrice(4.0f);
            order.setKaliumPrice(3.0f);

            order.setNitrogenousWeight(3.0f);
            order.setKaliumWeight(6.0f);
            order.setPhosphorusWeight(7.0f);

            order.setNitrogenousPriceSubtotal(12.0f);
            order.setKaliumPriceSubtotal(18.0f);
            order.setPhosphorusPriceSubtotal(15.0f);

            orderManager.insertOrder(order);

        }
    }

    @OnClick()
    public void onClick(){}

    @OnClick({R.id.btn_order_manager , R.id.tv_main})
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_order_manager:
                startActivity(new Intent(this,OrderFormActivity.class));
                break;
            case R.id.tv_main:

                userManager.loadUserByAll();
                consumerManager.loadConsumerByAll();
                Log.d("MainActivity", "onClick:");

                initData();
                break;
        }
    }


}
