package top.ovo.flide;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;

import java.lang.ref.SoftReference;

/**
 * Created by caojianfeng on 30/03/2018.
 */

public abstract class RequestMan {


    private static final String TAG = "==== RM ====";
    protected SoftReference<Activity> activitySoftReference;
    protected SoftReference<Context> contextSoftReference;

    protected String url;
    protected int placeHolderResId;
    protected int errorResId;
    protected float thumbnail;
    protected boolean cropCenter = false;
    protected boolean dontAnimate = false;
    protected boolean crossFade = false;
    protected int crossFadeDuration = 0;

    public RequestMan(Object contextWith) {
        if (contextWith instanceof Activity) {
            activitySoftReference = new SoftReference<>((Activity) contextWith);
        } else {
            contextSoftReference = new SoftReference<>((Context) contextWith);
        }

    }

    abstract public void init();


    public RequestMan load(String url) {
        this.url = url;
        return this;
    }

    public RequestMan placeholder(int resId) {
        this.placeHolderResId = resId;
        Log.e(TAG, "placeholder(" + resId + ") placeHolderResId:" + placeHolderResId, new Throwable());
        return this;
    }

    public RequestMan error(int resId) {
        this.errorResId = resId;
        return this;
    }

    public RequestMan thumbnail(float scale) {
        this.thumbnail = scale;
        return this;
    }

    public RequestMan diskCacheStrategy(Object strategy) {
        //ignore
        return this;
    }

    public RequestMan dontAnimate() {
        this.dontAnimate = true;
        return this;
    }

    public RequestMan crossFade() {
        this.crossFade = true;
        return this;
    }

    public RequestMan crossFade(int duration) {
        this.crossFadeDuration = duration;
        this.crossFade = true;
        return this;
    }

    public RequestMan centerCrop() {
        this.cropCenter = true;
        return this;
    }

    public RequestMan copy(RequestMan srcRequestMan){
        this.activitySoftReference = srcRequestMan.activitySoftReference;
        this.contextSoftReference = srcRequestMan.contextSoftReference;

        this.url = srcRequestMan.url;

        this.placeHolderResId = srcRequestMan.placeHolderResId;
        this.errorResId = srcRequestMan.errorResId;

        this.cropCenter = srcRequestMan.cropCenter;
        this.thumbnail = srcRequestMan.thumbnail;
        this.dontAnimate = srcRequestMan.dontAnimate;
        this.crossFade = srcRequestMan.crossFade;
        this.crossFadeDuration = srcRequestMan.crossFadeDuration;
        return this;
    }

    abstract public void into(View imageView);
}
