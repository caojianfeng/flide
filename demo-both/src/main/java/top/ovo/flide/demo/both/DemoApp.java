package top.ovo.flide.demo.both;

import android.app.Application;

import top.ovo.flide.Flide;
import top.ovo.flide.both.RequestManBothImpl;

/**
 * Created by caojianfeng on 29/03/2018.
 */

public class DemoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        Fresco.initialize(this);
        Flide.init(this, new RequestManBothImpl(this));
    }
}
