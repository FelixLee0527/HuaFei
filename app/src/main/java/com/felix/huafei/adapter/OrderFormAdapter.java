package com.felix.huafei.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.felix.huafei.R;
import com.felix.huafei.commonadapter.CommonAdapter;
import com.felix.huafei.commonadapter.CommonViewHolder;
import com.felix.huafei.modle.Order;

import java.util.List;

/**
 * Created by felix on 2017/3/9.
 */

public class OrderFormAdapter extends CommonAdapter<Order>
{
    public OrderFormAdapter(Context context, int layoutId, List<Order> datas)
    {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(CommonViewHolder holder, Order order, int position)
    {
        Log.d("OrderFormAdapter", "convert:" + order.getConsumerName());
        holder.setText(R.id.tv_number, String.valueOf(order.getId()));
        holder.setText(R.id.tv_order_form_time, order.getOrderTime());
        holder.setText(R.id.tv_order_form_number, String.valueOf(order.getOrderId()));
        holder.setText(R.id.tv_order_form_money, String.valueOf(order.getMoney()));
        holder.setText(R.id.tv_order_form_payment_status, order.getPaymentStatus() == 0 ? "未付款" : "已付款");
        holder.setText(R.id.tv_order_form_status, order.getOrderStatus());
        holder.setText(R.id.tv_order_form_remarks, order.getRemarks());

        ((CheckBox) holder.getView(R.id.cb_order_form_operate)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {

            }
        });
    }
}
