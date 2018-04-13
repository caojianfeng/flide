package top.ovo.flide.demo.demo_base.demo_base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import top.ovo.demo_base.R;

public abstract class BaseDemoActivity extends AppCompatActivity implements View.OnClickListener {
    abstract protected void onLoadImageClicked();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initView();
    }

    protected void initView() {
        ImageButton settingsButton = findViewById(R.id.button_settings);
        settingsButton.setOnClickListener(this);

        Button loadButton = findViewById(R.id.button_load);
        loadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
