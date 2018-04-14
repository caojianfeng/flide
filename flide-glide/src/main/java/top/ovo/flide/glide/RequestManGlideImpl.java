package top.ovo.flide.glide;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;


import top.ovo.flide.RequestMan;

/**
 * Created by caojianfeng on 30/03/2018.
 */

public class RequestManGlideImpl extends RequestMan {

    DiskCacheStrategy diskCacheStrategy;

    public RequestManGlideImpl(Object contextWith) {
        super(contextWith);
    }

    @Override
    public void init() {

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


    private RequestOptions createRequestOptions() {
        RequestOptions ro = null;
        if (this.centerCrop) {
            if (ro == null) {
                ro = new RequestOptions();
            }
            ro.centerCrop();
        }
        if (this.dontAnimate) {
            if (ro == null) {
                ro = new RequestOptions();
            }
            ro.dontAnimate();
        }

        if (this.placeHolderResId != 0) {
            if (ro == null) {
                ro = new RequestOptions();
            }
            ro.placeholder(this.placeHolderResId);
        }

        if (this.errorResId != 0) {
            if (ro == null) {
                ro = new RequestOptions();
            }
            ro.error(this.errorResId);
        }

        if (this.diskCacheStrategy != null) {
            if (ro == null) {
                ro = new RequestOptions();
            }
            ro.diskCacheStrategy(this.diskCacheStrategy);
        }
        return ro;
    }

    @Override
    public void into(View view) {
        if (!(view instanceof ImageView)) {
            throw new RuntimeException("ImageView needed but "
                    + view.getClass().getCanonicalName() + " found");
        }
        ImageView imageView = (ImageView) view;

        RequestManager rm = null;
        Context context = this.contextSoftReference.get();
        if (context != null) {
            rm = Glide.with(context);
        } else {
            Activity activity = this.activitySoftReference.get();
            rm = Glide.with(activity);
        }


        RequestBuilder<Drawable> rb = rm.load(this.url);
        RequestOptions ro = createRequestOptions();
        if (ro != null) {
            rb.apply(ro);
        }
        rb.thumbnail(this.thumbnail).into(imageView);
    }
}
