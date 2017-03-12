package com.felix.huafei.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.felix.huafei.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by felix on 2017/3/12.
 */

public class ChoseStandardProductActivity extends BaseActivity
{
    @BindView(R.id.btn_back)             Button      btnBack;
    @BindView(R.id.btn_confirm)          Button      btnConfirm;
    @BindView(R.id.rb_standard_product1) RadioButton rbStandardProduct1;
    @BindView(R.id.rb_standard_product2) RadioButton rbStandardProduct2;
    @BindView(R.id.rg_standard_product)  RadioGroup  rgStandardProduct;

    @Override
    public int setContainViewLayout()
    {
        return R.layout.activity_standard_product;
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

        rgStandardProduct.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                if(checkedId == R.id.rb_standard_product1)
                {
                }
                else if(checkedId == R.id.rb_standard_product2)
                {
                }
                else
                {
                }
            }
        });
    }

    @OnClick({R.id.btn_back , R.id.btn_confirm})
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_confirm:
                break;
        }
    }
}
