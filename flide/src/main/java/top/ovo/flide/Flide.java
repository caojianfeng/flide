package top.ovo.flide;

import android.content.Context;

/**
 * Created by caojianfeng on 29/03/2018.
 */

public class Flide {


    private static RequestMan requestMan;

    public static void init(Context context, RequestMan implementsBy) {
        requestMan = implementsBy;
        requestMan.init();

    }

    public static RequestMan with(Context context) {
        return requestMan;
    }

}
