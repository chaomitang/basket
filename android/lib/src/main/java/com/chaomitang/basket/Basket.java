package com.chaomitang.basket;


import android.annotation.SuppressLint;
import android.content.Context;

public class Basket {

    @SuppressLint("StaticFieldLeak")
    private static Basket sInstance;
    private Context mContext;

    private Basket(Context context) {
        this.mContext = context;
    }

    /**
     * 获取实例
     */
    private static Basket getInstance() {
        if (sInstance == null) {
            synchronized (Basket.class) {
                if (sInstance == null) {
                    if (BasketContextProvider.sContext == null) {
                        throw new IllegalStateException("context == null");
                    }
                    sInstance = new Basket(BasketContextProvider.sContext);
                }
            }
        }
        return sInstance;
    }

    public static Context getAppContext() {
        return getInstance().mContext;
    }
}
