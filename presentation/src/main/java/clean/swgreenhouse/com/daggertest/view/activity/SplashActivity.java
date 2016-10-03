package clean.swgreenhouse.com.daggertest.view.activity;

import android.os.Bundle;

import clean.swgreenhouse.com.daggertest.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        navigator.navigateToResourcesList(this);



        finish();
    }


}