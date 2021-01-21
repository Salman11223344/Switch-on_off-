package com.example.language_switchlogin_registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Locale;

public class DashBoardActivity extends AppCompatActivity {
    private Switch sw;
    private TextView change;
static int changeLanguage=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        initFunction();
        initListener();
    }

    private void initListener() {
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    setApplicationLocale("en");
                } else {
                    // The toggle is disabled
                    setApplicationLocale("bn");
                }
            }
        });

    }

    private void initFunction() {
         sw = findViewById(R.id.switch1);
         change = findViewById(R.id.change);

    }


    private void setApplicationLocale(String locale)
    {
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(new Locale(locale.toLowerCase()));
        } else {
            config.locale = new Locale(locale.toLowerCase());
        }
        resources.updateConfiguration(config, dm);
        startActivity(new Intent(DashBoardActivity.this,DashBoardActivity.class));
        finish();
      //  DashBoardActivity.this.recreate();
        //recreate();
    }
}