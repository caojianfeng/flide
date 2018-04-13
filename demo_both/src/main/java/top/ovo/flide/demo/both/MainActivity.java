package top.ovo.flide.demo.both;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import pub.devrel.easypermissions.EasyPermissions;
import top.ovo.demo_base.BaseDemoActivity;

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
