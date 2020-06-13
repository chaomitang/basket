package com.chaomitang.basket.density;

import android.content.Context;

import com.chaomitang.basket.Basket;

public class DensityTool {

    /**
     * dip2px
     * @param dpValue
     * @return
     */
    public static int dip2px(float dpValue) {
        return dip2px(Basket.getAppContext(), dpValue);
    }

    private static int dip2px(Context context, float dpValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(0.5F + dpValue * fontScale);
    }

    /**
     * px2dip
     * @param pxValue
     * @return
     */
    public static int px2dip(float pxValue) {
        return px2dip(Basket.getAppContext(), pxValue);
    }

    private static int px2dip(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int)(0.5F + pxValue / fontScale);
    }

    /**
     * sp2px
     * @param spValue
     * @return
     */
    public static int sp2px(float spValue) {
        return sp2px(Basket.getAppContext(), spValue);
    }

    private static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
