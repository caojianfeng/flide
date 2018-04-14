package top.ovo.flide.demo.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import pub.devrel.easypermissions.EasyPermissions;

public abstract class BaseDemoActivity extends AppCompatActivity implements View.OnClickListener {

    protected class ImageConfigs {
        String url;
        float scale;
        int placeHolderResId;
        int errorResId;


        public ImageConfigs(String url) {
            this.url = url;
        }

        public ImageConfigs setScale(float scale) {
            this.scale = scale;
            return this;
        }

        public String getUrl() {
            return url;
        }

        public float getScale() {
            return scale;
        }


        public int getPlaceHolderResId() {
            return placeHolderResId;
        }

        public ImageConfigs setPlaceHolderResId(int placeHolderResId) {
            this.placeHolderResId = placeHolderResId;
            return this;
        }

        public int getErrorResId() {
            return errorResId;
        }

        public ImageConfigs setErrorResId(int errorResId) {
            this.errorResId = errorResId;
            return this;
        }
    }

    abstract protected void onLoadImageClicked(ImageConfigs imageConfigs);

    EditText editTextUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    protected void initView() {
        ImageButton settingsButton = findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(this);

        Button loadButton = findViewById(R.id.button_load);
        loadButton.setOnClickListener(this);

        editTextUrl = findViewById(R.id.editTextUrl);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_load) {
            String url = editTextUrl.getText().toString();

            onLoadImageClicked(new ImageConfigs(url).setScale(0.5f)
                    .setPlaceHolderResId(R.mipmap.place_holder)
                    .setErrorResId(R.mipmap.image_error));

        } else if (v.getId() == R.id.button_settings) {

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
