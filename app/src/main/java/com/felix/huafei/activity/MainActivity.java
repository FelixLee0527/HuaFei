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

            order.setPlantingArea(String.valueOf(random.nextInt(100)) + "/亩");
            order.setPlantingCrops("水稻");
            order.setGrowthStage("秧苗期");

            order.setElement1Price(5.0f);
            order.setElement2Price(3.0f);
            order.setElement3Price(6.0f);
            order.setElement4Price(1.0f);
            order.setElement5Price(2.0f);
            order.setElement6Price(8.0f);
            order.setElement7Price(9.0f);


            order.setElement1Weight(1.0f);
            order.setElement2Weight(7.0f);
            order.setElement3Weight(3.0f);
            order.setElement4Weight(8.0f);
            order.setElement5Weight(2.0f);
            order.setElement6Weight(1.0f);
            order.setElement7Weight(8.0f);

            order.setElement1PriceSubtotal(5.0f);
            order.setElement2PriceSubtotal(21.0f);
            order.setElement3PriceSubtotal(18.0f);
            order.setElement4PriceSubtotal(8.0f);
            order.setElement5PriceSubtotal(4.0f);
            order.setElement6PriceSubtotal(8.0f);
            order.setElement7PriceSubtotal(72.0f);

            orderManager.insertOrder(order);

        }
    }

    @OnClick()
    public void onClick(){}

    @OnClick({R.id.btn_order_manager , R.id.tv_main , R.id.btn_fertilizer_complete})
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_order_manager:
                startActivity(new Intent(this, OrderFormActivity.class));
                break;

            case R.id.btn_fertilizer_complete:
                startActivity(new Intent(this, FertilizerCompleteActivity.class));

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
