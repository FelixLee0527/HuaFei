package com.felix.huafei.utils;

import java.math.BigDecimal;

/**
 * Created by felix on 2017/3/10.
 */

public class CommonUtils
{
    /**
     * float 设置精度
     *
     * @param d            需要操作的数值
     * @param decimalPlace 精确到多少位
     * @return 返回值
     */
    public static float roundOffFloat(float d, int decimalPlace)
    {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_DOWN);

        return bd.floatValue();
    }
}
