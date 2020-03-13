package com.chaomitang.basket;


import android.annotation.SuppressLint;
import android.content.Context;

public class BasketContext {

    @SuppressLint("StaticFieldLeak")
    private static BasketContext sInstance;
    private Context mContext;

    private BasketContext(Context context) {
        this.mContext = context;
    }

    /**
     * 获取实例
     */
    private static BasketContext getInstance() {
        if (sInstance == null) {
            synchronized (BasketContext.class) {
                if (sInstance == null) {
                    if (BasketContextProvider.sContext == null) {
                        throw new IllegalStateException("context == null");
                    }
                    sInstance = new BasketContext(BasketContextProvider.sContext);
                }
            }
        }
        return sInstance;
    }

    public static Context getAppContext() {
        return getInstance().mContext;
    }
}
