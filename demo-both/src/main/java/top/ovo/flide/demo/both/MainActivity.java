package top.ovo.flide.demo.both;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

import pub.devrel.easypermissions.EasyPermissions;
import top.ovo.flide.Flide;
import top.ovo.flide.demo.base.BaseDemoActivity;
import top.ovo.flide.fresco.DiskCacheStrategy;

public class MainActivity extends BaseDemoActivity {


    private static final String TAG = "MainActivity";

    ImageView imageView;
    SimpleDraweeView simpleDraweeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imageView = findViewById(R.id.imageView);
        simpleDraweeView = findViewById(R.id.simpleDraweeView);
    }

    @Override
    protected void onLoadImageClicked(ImageConfigs imageConfigs) {
        Log.i(TAG, "onLoadImageClicked");
        View[] views = {imageView, simpleDraweeView};
        for (View view : views) {
            Flide.with(this)
                    .load(imageConfigs.getUrl())
                    .thumbnail(imageConfigs.getScale())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontAnimate()
                    .centerInside()
                    .placeholder(imageConfigs.getPlaceHolderResId())
                    .error(imageConfigs.getErrorResId())
                    .into(view);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
