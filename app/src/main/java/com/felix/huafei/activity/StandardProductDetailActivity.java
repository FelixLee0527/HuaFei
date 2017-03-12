package com.felix.huafei.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.felix.huafei.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by felix on 2017/3/12.
 */

public class StandardProductDetailActivity extends BaseActivity implements CheckBox.OnCheckedChangeListener
{
    @BindView(R.id.tv_select_product) TextView tvSelectProduct;
    @BindView(R.id.tv_material_1)     TextView tvMaterial1;
    @BindView(R.id.tv_material_2)     TextView tvMaterial2;
    @BindView(R.id.tv_material_3)     TextView tvMaterial3;
    @BindView(R.id.tv_material_4)     TextView tvMaterial4;
    @BindView(R.id.tv_material_5)     TextView tvMaterial5;
    @BindView(R.id.tv_material_6)     TextView tvMaterial6;
    @BindView(R.id.edt_1)             EditText edt1;
    @BindView(R.id.edt_2)             EditText edt2;
    @BindView(R.id.edt_3)             EditText edt3;
    @BindView(R.id.btn_back)          Button   btnBack;
    @BindView(R.id.btn_confirm)       Button   btnConfirm;
    @BindView(R.id.cb_mode_1)         CheckBox cbMode1;
    @BindView(R.id.cb_mode_2)         CheckBox cbMode2;

    @Override
    public int setContainViewLayout()
    {
        return R.layout.activity_standard_product_detail;
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
        initListener();
    }

    private void initListener()
    {
        cbMode1.setOnCheckedChangeListener(this);
    }

    @OnClick({R.id.btn_back , R.id.btn_confirm})
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_back:
                break;
            case R.id.btn_confirm:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if(buttonView.getId() == R.id.cb_mode_1)
        {
            if(isChecked)
            {
                edt1.setEnabled(true);
                edt2.setEnabled(true);
                edt3.setEnabled(false);
                cbMode2.setChecked(false);
            }

        }
        else if(buttonView.getId() == R.id.cb_mode_2)
        {
            edt1.setEnabled(false);
            edt2.setEnabled(false);
            edt3.setEnabled(true);
            cbMode1.setChecked(false);
        }
    }
}
