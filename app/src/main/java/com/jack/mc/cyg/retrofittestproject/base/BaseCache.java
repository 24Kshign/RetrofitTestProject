package com.jack.mc.cyg.retrofittestproject.base;

import android.content.Context;

import com.jack.mc.cyg.retrofittestproject.cache.ACache;


/**
 * BaseCache
 * Created by tsy on 16/7/25.
 */
public class BaseCache {

    protected ACache mCache;

    public BaseCache(Context context) {
        mCache = ACache.get(context);
    }
}
