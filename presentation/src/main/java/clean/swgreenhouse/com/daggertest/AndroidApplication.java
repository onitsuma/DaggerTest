package clean.swgreenhouse.com.daggertest;

import android.app.Application;

import clean.swgreenhouse.com.daggertest.dependency.component.DaggerStorageComponent;
import clean.swgreenhouse.com.daggertest.dependency.component.StorageComponent;
import clean.swgreenhouse.com.daggertest.dependency.module.StorageModule;

/**
 * Created by csuay on 21/09/2016.
 */
public class AndroidApplication extends Application {


    private StorageComponent dbComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();

    }

    private void initializeInjector() {
        this.dbComponent = DaggerStorageComponent.builder()
                .storageModule(new StorageModule(this, "dagger.db"))
                .build();
    }

    public StorageComponent getDbComponent() {
        return dbComponent;
    }
}
