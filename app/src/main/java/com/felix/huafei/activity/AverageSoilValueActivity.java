package com.felix.huafei.activity;

import android.os.Bundle;
import android.widget.ProgressBar;

import com.felix.huafei.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by felix on 2017/3/11.
 */

public class AverageSoilValueActivity extends BaseActivity

{

    @BindView(R.id.pb_nitrogenous_average) ProgressBar pbNitrogenousAverage;
    @BindView(R.id.pb_phosphorus_average)  ProgressBar pbPhosphorusAverage;
    @BindView(R.id.pb_kalinum_average)     ProgressBar pbKalinumAverage;


    @Override
    public int setContainViewLayout()
    {
        return R.layout.activity_average_soil_value;
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
}
