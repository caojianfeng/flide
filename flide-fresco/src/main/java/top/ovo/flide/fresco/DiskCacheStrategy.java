package top.ovo.flide.fresco;

import android.util.Log;

/**
 * Created by caojianfeng on 03/04/2018.
 */

public class DiskCacheStrategy {
    private static final String TAG = "===DCS===";
    public static Object ALL = null;
    public static Object RESOURCE = null;
    public static Object DATA = null;
    public static Object AUTOMATIC = null;
    public static Object NONE = null;

    public static Object SOURCE = null;
    public static Object RESULT = null;

    public static void init() {
        Class clz = null;
        try {
            clz = Class.forName("com.bumptech.glide.load.engine.DiskCacheStrategy");
        } catch (ClassNotFoundException e) {
            Log.i(TAG, "", e);
            return;
        }

        try {
            DiskCacheStrategy.ALL = clz.getField("ALL");
            Log.i(TAG, "ALL");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "ALL", e);
        }

        try {
            DiskCacheStrategy.RESOURCE = clz.getField("RESOURCE");
            Log.i(TAG, "RESOURCE");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "RESOURCE", e);
        }

        try {
            DiskCacheStrategy.DATA = clz.getField("DATA");
            Log.i(TAG, "DATA");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "DATA", e);
        }

        try {
            DiskCacheStrategy.AUTOMATIC = clz.getField("AUTOMATIC");
            Log.i(TAG, "AUTOMATIC");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "AUTOMATIC", e);
        }

        try {
            DiskCacheStrategy.NONE = clz.getField("NONE");
            Log.i(TAG, "NONE");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "NONE", e);
        }

        try {
            DiskCacheStrategy.NONE = clz.getField("SOURCE");
            Log.i(TAG, "SOURCE");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "SOURCE:" + e.getMessage());
        }

        try {
            DiskCacheStrategy.NONE = clz.getField("RESULT");
            Log.i(TAG, "RESULT");
        } catch (NoSuchFieldException e) {
            Log.e(TAG, "RESULT:" + e.getMessage());
        }
    }
}
