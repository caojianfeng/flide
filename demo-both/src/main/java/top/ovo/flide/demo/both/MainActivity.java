package top.ovo.flide.demo.both;

import android.support.annotation.NonNull;
import android.util.Log;

import pub.devrel.easypermissions.EasyPermissions;
import top.ovo.flide.demo.demo_base.demo_base.BaseDemoActivity;

public class MainActivity extends BaseDemoActivity {


    private static final String TAG = "MainActivity";

    @Override
    protected void onLoadImageClicked() {
        Log.i(TAG,"onLoadImageClicked");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
