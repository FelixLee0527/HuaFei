package com.felix.huafei.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.felix.huafei.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by felix on 2017/3/12.
 */

public class FertilizerModeSelectActivity extends BaseActivity
{
    @BindView(R.id.btn_standard_produce) Button btnStandardProduce;
    @BindView(R.id.btn_order_manager)    Button btnOrderManager;
    @BindView(R.id.btn_view_device_info) Button btnViewDeviceInfo;

    @Override
    public int setContainViewLayout()
    {
        return R.layout.activity_fertilizer_mode_select;
    }

    @Override
    public void initViw()
    {

    }

    @Override
    public void initData()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @OnClick({R.id.btn_standard_produce , R.id.btn_order_manager , R.id.btn_view_device_info})
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_standard_produce:
                break;
            case R.id.btn_order_manager:
                break;
            case R.id.btn_view_device_info:
                break;
        }
    }
}
