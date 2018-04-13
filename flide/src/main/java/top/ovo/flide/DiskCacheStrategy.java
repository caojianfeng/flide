package top.ovo.flide;

/**
 * Created by caojianfeng on 03/04/2018.
 */

public class DiskCacheStrategy {
    public static Object ALL = null;
    public static Object RESOURCE = null;
    public static Object DATA = null;
    public static Object AUTOMATIC = null;
    public static Object NONE = null;

    public static Object SOURCE = null;
    public static Object RESULT = null;

    public static void init() {
        DiskCacheStrategy.ALL = com.bumptech.glide.load.engine.DiskCacheStrategy.ALL;
        DiskCacheStrategy.RESOURCE = com.bumptech.glide.load.engine.DiskCacheStrategy.RESOURCE;
        DiskCacheStrategy.DATA = com.bumptech.glide.load.engine.DiskCacheStrategy.DATA;
        DiskCacheStrategy.AUTOMATIC = com.bumptech.glide.load.engine.DiskCacheStrategy.AUTOMATIC;
        DiskCacheStrategy.NONE = com.bumptech.glide.load.engine.DiskCacheStrategy.NONE;
    }
}
