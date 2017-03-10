package com.felix.huafei.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.felix.huafei.R;
import com.felix.huafei.adapter.OrderFormAdapter;
import com.felix.huafei.db.order.OrderManager;
import com.felix.huafei.modle.Order;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felix on 2017/3/9.
 */

public class OrderFormActivity extends BaseActivity implements OrderFormAdapter.OnItemClickListener
{
    @BindView(R.id.tv_all_order_form)      TextView     tvAllOrderForm;
    @BindView(R.id.tv_not_pay_order_form)  TextView     tvNotPayOrderForm;
    @BindView(R.id.tv_not_take_order_form) TextView     tvNotTakeOrderForm;
    @BindView(R.id.tv_complete_order_form) TextView     tvCompleteOrderForm;
    @BindView(R.id.rv_order_form)          RecyclerView rvOrderForm;

    private OrderManager     orderManager;
    private OrderFormAdapter orderFormAdapter;
    private List<Order> orderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
    }

    @Override
    public int setContainViewLayout()
    {
        return R.layout.activity_order_form;
    }

    @Override
    public void initViw()
    {
        orderManager = new OrderManager(this);
        orderFormAdapter = new OrderFormAdapter(this, R.layout.item_order_form, orderList);
        orderFormAdapter.setOnItemClickListener(this);
        rvOrderForm.setLayoutManager(new LinearLayoutManager(this));
        rvOrderForm.setAdapter(orderFormAdapter);


    }

    @Override
    public void initData()
    {
        orderList.addAll(orderManager.loadOrderByAll());
        Log.d("OrderFormActivity", "onCreate:" + orderList.size());

        tvAllOrderForm.setText("所有订单("+orderList.size()+")");
        tvNotPayOrderForm.setText("未付款("+orderList.size()+")");
        tvNotTakeOrderForm.setText("未取货("+orderList.size()+")");
        tvCompleteOrderForm.setText("已完成("+orderList.size()+")");

        orderFormAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position)
    {
        Bundle bundle=new Bundle();
        bundle.putSerializable("order",orderList.get(position));
        Intent intent=new Intent(this,OrderFormDetailActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position)
    {
        return false;
    }
}
