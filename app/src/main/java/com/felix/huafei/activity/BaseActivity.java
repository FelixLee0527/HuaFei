package com.felix.huafei.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.felix.huafei.R;
import com.felix.huafei.utils.DateUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.ref.WeakReference;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by felix on 2017/3/8.
 */

public abstract class BaseActivity extends AutoLayoutActivity
{

    private static final int GET_TIME=1;

    @BindView(R.id.tv_current_time) TextView    tvCurrentTime;
    @BindView(R.id.tv_current_day)  TextView    tvCurrentDay;
    @BindView(R.id.tv_user)         TextView    tvUser;
    @BindView(R.id.ib_close)        ImageButton ibClose;

    private int layoutId;
    private boolean isRunning = true;

    private TimeHandler timeHandler = new TimeHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        layoutId = setContainViewLayout();
        setContentView(layoutId);

        ButterKnife.bind(this);

        initTitleBar();

        initViw();

        initData();
    }

    private void initTitleBar()
    {

        tvCurrentDay.setText(DateUtils.getDayAndWeek());
        tvCurrentTime.setText(DateUtils.getTime());

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(isRunning)
                {
                    timeHandler.sendEmptyMessage(GET_TIME);
                    Log.d("BaseActivity", "run:" + DateUtils.getTime());
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @OnClick({R.id.tv_user , R.id.ib_close})
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.tv_user:
                break;
            case R.id.ib_close:
                break;
        }
    }

    public abstract int setContainViewLayout();

    public abstract void initViw();

    public abstract void initData();


    static class TimeHandler extends Handler
    {
        WeakReference<BaseActivity> mActivity;

        TimeHandler(BaseActivity activity)
        {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg)
        {
            BaseActivity theAvActivity = mActivity.get();
            switch(msg.what)
            {
                case BaseActivity.GET_TIME:
                    theAvActivity.tvCurrentTime.setText(DateUtils.getTime());
                    break;
            }
        }
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        isRunning=false;
        timeHandler.removeCallbacksAndMessages(null);
    }
}
