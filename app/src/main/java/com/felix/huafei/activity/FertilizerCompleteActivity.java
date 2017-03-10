package com.felix.huafei.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.felix.huafei.R;
import com.felix.huafei.utils.CommonUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

/**
 * Created by felix on 2017/3/10.
 */

public class FertilizerCompleteActivity extends BaseActivity
{
    @BindView(R.id.edt_1)        EditText edt1;
    @BindView(R.id.edt_2)        EditText edt2;
    @BindView(R.id.edt_3)        EditText edt3;
    @BindView(R.id.edt_4)        EditText edt4;
    @BindView(R.id.edt_5)        EditText edt5;
    @BindView(R.id.edt_6)        EditText edt6;
    @BindView(R.id.edt_7)        EditText edt7;
    @BindView(R.id.btn_complete) Button   btnComplete;

    @BindViews({R.id.edt_1 , R.id.edt_2 , R.id.edt_3 , R.id.edt_4 , R.id.edt_5 , R.id.edt_6 , R.id.edt_7}) List<View> edtViews;

    @Override
    public int setContainViewLayout()
    {
        return R.layout.activity_fertilizer_complete;
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
        initKeyListener();
    }

    @OnClick(R.id.btn_complete)
    public void onClick(){}

    private void initKeyListener()
    {
        for(int i = 0; i < edtViews.size(); i++)
        {
            if(edtViews.get(i) instanceof EditText)
            {
                ((EditText) edtViews.get(i)).setOnEditorActionListener(onKeyListener);
            }


        }
    }

    private TextView.OnEditorActionListener onKeyListener = new TextView.OnEditorActionListener()
    {
        @Override
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
        {
            if(i == EditorInfo.IME_ACTION_SEND || i == EditorInfo.IME_ACTION_DONE || (KeyEvent.KEYCODE_ENTER == keyEvent.getKeyCode()))
            {
                /*隐藏软键盘*/
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if(inputMethodManager.isActive())
                {
                    inputMethodManager.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
                }
                if(textView.getText().toString().isEmpty())//输入内容为空
                {
                    // TODO: 2017/3/10 输入值为空
                    return false;
                }

                switch(textView.getId())
                {
                    case R.id.edt_1:
                        break;
                    case R.id.edt_2:
                        break;
                    case R.id.edt_3:
                        break;
                    case R.id.edt_4:
                        break;
                    case R.id.edt_5:
                        break;
                    case R.id.edt_6:
                        break;
                    case R.id.edt_7:
                        break;
                }
                return true;
            }
            return false;
        }
    };

}
