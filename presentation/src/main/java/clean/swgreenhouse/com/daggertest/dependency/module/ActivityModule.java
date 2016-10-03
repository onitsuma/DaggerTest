package clean.swgreenhouse.com.daggertest.dependency.module;

import android.app.Activity;

import clean.swgreenhouse.com.daggertest.dependency.ActivityScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by csuay on 22/09/2016.
 */
@Module
public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    Activity activity() {
        return this.activity;
    }

}
