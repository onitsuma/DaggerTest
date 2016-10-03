package clean.swgreenhouse.com.daggertest.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import clean.swgreenhouse.com.daggertest.AndroidApplication;
import clean.swgreenhouse.com.daggertest.dependency.component.StorageComponent;
import clean.swgreenhouse.com.daggertest.navigation.Navigator;
import clean.swgreenhouse.com.data.model.ResourceDao;

/**
 * Created by csuay on 21/09/2016.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    protected Navigator navigator;

    @Inject
    protected ResourceDao resourceDao;

    @Inject
    protected SharedPreferences sharedPreferences;

    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();

    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getStorageComponent().inject(this);
    }

    protected StorageComponent getStorageComponent() {
        return ((AndroidApplication) getApplication()).getDbComponent();
    }
}
