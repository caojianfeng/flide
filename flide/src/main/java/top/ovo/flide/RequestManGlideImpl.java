package top.ovo.flide;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.lang.ref.SoftReference;

/**
 * Created by caojianfeng on 30/03/2018.
 */

public class RequestManGlideImpl extends RequestMan {

    DiskCacheStrategy diskCacheStrategy;

    public static void initContext(){

    }

    public RequestManGlideImpl(Object contextWith) {
        super(contextWith);
    }

    @Override
    public RequestMan diskCacheStrategy(Object strategy) {
        if (!(strategy instanceof DiskCacheStrategy)) {
            throw new RuntimeException("Need DiskCacheStrategy but '"
                    + strategy.getClass().getName() + "' given");
        }
        DiskCacheStrategy diskCacheStrategy = (DiskCacheStrategy) strategy;
        this.diskCacheStrategy = diskCacheStrategy;
        return this;
    }


    @Override
    public void into(View imageView) {

    }
}
