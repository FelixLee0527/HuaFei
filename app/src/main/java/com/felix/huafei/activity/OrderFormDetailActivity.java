package com.felix.huafei.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.felix.huafei.R;
import com.felix.huafei.modle.Order;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by felix on 2017/3/9.
 */

public class OrderFormDetailActivity extends BaseActivity
{
    @BindView(R.id.tv_consumer_account)        TextView    tvConsumerAccount;
    @BindView(R.id.tv_planting_crops)          TextView    tvPlantingCrops;
    @BindView(R.id.tv_planting_area)           TextView    tvPlantingArea;
    @BindView(R.id.tv_consumer_cell_phone)     TextView    tvConsumerCellPhone;
    @BindView(R.id.tv_growth_stage)            TextView    tvGrowthStage;
    @BindView(R.id.tv_remarks)                 TextView    tvRemarks;
    @BindView(R.id.tv_order_time)              TextView    tvOrderTime;
    @BindView(R.id.tv_order_id)                TextView    tvOrderId;
    @BindView(R.id.tv_nitrogenous_price)       TextView    tvNitrogenousPrice;
    @BindView(R.id.tv_nitrogenous_weight)      TextView    tvNitrogenousWeight;
    @BindView(R.id.tv_nitrogenous_total_money) TextView    tvNitrogenousTotalMoney;
    @BindView(R.id.tv_phosphorus_price)        TextView    tvPhosphorusPrice;
    @BindView(R.id.tv_phosphorus_weight)       TextView    tvPhosphorusWeight;
    @BindView(R.id.tv_phosphorus_total_money)  TextView    tvPhosphorusTotalMoney;
    @BindView(R.id.tv_kalium_price)            TextView    tvKaliumPrice;
    @BindView(R.id.tv_kalium_weight)           TextView    tvKaliumWeight;
    @BindView(R.id.tv_kalium_total_money)      TextView    tvKaliumTotalMoney;
    @BindView(R.id.tv_total_money)             TextView    tvTotalMoney;
    @BindView(R.id.btn_back)                   Button      btnBack;
    @BindView(R.id.btn_start)                  Button      btnStart;



    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int setContainViewLayout()
    {
        return R.layout.activity_order_form_detail;
    }

    @Override
    public void initViw()
    {

    }

    @Override
    public void initData()
    {
        Bundle bundle = getIntent().getExtras();
        order = (Order) bundle.getSerializable("order");
        if(order != null)
        {

            tvConsumerAccount.setText(String.valueOf(order.getConsumerId()));
            tvPlantingCrops.setText(order.getPlantingCrops());
            tvPlantingArea.setText(order.getPlantingArea());
            //            tvConsumerCellPhone.setText(order.get());
            tvGrowthStage.setText(order.getGrowthStage());
            tvRemarks.setText(order.getRemarks());
            tvOrderTime.setText(order.getOrderTime());
            tvOrderId.setText(order.getOrderId());

            tvNitrogenousPrice.setText(String.valueOf(order.getNitrogenousPrice()));
            tvNitrogenousWeight.setText(String.valueOf(order.getNitrogenousWeight()));
            tvNitrogenousTotalMoney.setText(String.valueOf(order.getNitrogenousPriceSubtotal()));

            tvPhosphorusPrice.setText(String.valueOf(order.getPhosphorusPrice()));
            tvPhosphorusWeight.setText(String.valueOf(order.getPhosphorusWeight()));
            tvPhosphorusTotalMoney.setText(String.valueOf(order.getPhosphorusPriceSubtotal()));

            tvKaliumPrice.setText(String.valueOf(order.getPhosphorusPrice()));
            tvKaliumWeight.setText(String.valueOf(order.getKaliumWeight()));
            tvKaliumTotalMoney.setText(String.valueOf(order.getKaliumPriceSubtotal()));

            tvTotalMoney.setText(String.valueOf(order.getNitrogenousPriceSubtotal() + order.getPhosphorusPriceSubtotal() + order.getKaliumPriceSubtotal()));

        }

    }

    @OnClick({R.id.btn_back , R.id.btn_start})
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_start:
                break;
        }
    }


}
