package top.ovo.flide.both;

import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import top.ovo.flide.RequestMan;
import top.ovo.flide.fresco.RequestManFrescoImpl;
import top.ovo.flide.glide.RequestManGlideImpl;

/**
 * Created by caojianfeng on 30/03/2018.
 */

public class RequestManBothImpl extends RequestMan {


    private RequestManGlideImpl requestManGlide;
    private RequestManFrescoImpl requestManFresco;

    public RequestManBothImpl(Object contextWith) {
        super(contextWith);
        requestManGlide =  new RequestManGlideImpl(contextWith);
        requestManFresco = new RequestManFrescoImpl(contextWith);
    }

    @Override
    public void init() {
        requestManFresco.init();
        requestManGlide.init();
    }

    @Override
    public void into(View imageView) {
        RequestMan requestMan = null;
        if (imageView instanceof SimpleDraweeView) {
            requestMan = requestManFresco;
        } else if (imageView instanceof ImageView) {
            requestMan = requestManGlide;
        } else {
            return;
        }
        requestMan.init();
    }
}
