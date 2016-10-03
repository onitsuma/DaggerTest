package clean.swgreenhouse.com.daggertest.dependency.component;

import javax.inject.Singleton;

import clean.swgreenhouse.com.daggertest.dependency.module.StorageModule;
import clean.swgreenhouse.com.daggertest.view.activity.BaseActivity;
import clean.swgreenhouse.com.data.model.ResourceDao;
import dagger.Component;

/**
 * Created by csuay on 22/09/2016.
 */
@Singleton
@Component(modules = {StorageModule.class})
public interface StorageComponent {
    void inject(BaseActivity baseActivity);

    ResourceDao resourceDao();
}
