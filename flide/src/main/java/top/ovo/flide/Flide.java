package top.ovo.flide;

import android.app.Activity;
import android.content.Context;
//import android.widget.ImageView;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.lang.ref.SoftReference;

/**
 * Created by caojianfeng on 29/03/2018.
 */

public class Flide {


    public enum ImplementsBy {
        FrescoOnly,
        GlideOnley,
        BothGlideAndFresco
    }

    private static ImplementsBy sImplementsBy;

    public static void init(Context context, ImplementsBy implementsBy) {
        sImplementsBy = implementsBy;
        if (sImplementsBy == ImplementsBy.BothGlideAndFresco || sImplementsBy == ImplementsBy.FrescoOnly) {
            Fresco.initialize(context);
        }

        if(sImplementsBy == ImplementsBy.BothGlideAndFresco || sImplementsBy == ImplementsBy.GlideOnley){
            DiskCacheStrategy.init();
        }
    }

    public static RequestMan with(Context context) {
        switch (sImplementsBy) {
            case FrescoOnly: {
                return new RequestManFrescoImpl(context);
            }
            case GlideOnley: {
                return new RequestManGlideImpl(context);
            }
            case BothGlideAndFresco:
            default:{
                return new RequestManBothImpl(context);
            }
        }
    }

}
