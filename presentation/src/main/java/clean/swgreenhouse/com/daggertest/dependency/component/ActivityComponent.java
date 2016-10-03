package clean.swgreenhouse.com.daggertest.dependency.component;

import android.app.Activity;

import clean.swgreenhouse.com.daggertest.dependency.ActivityScope;
import clean.swgreenhouse.com.daggertest.dependency.module.ActivityModule;
import dagger.Component;

/**
 * Created by csuay on 22/09/2016.
 */

@ActivityScope
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {

    Activity activity();

}
