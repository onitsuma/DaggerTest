package clean.swgreenhouse.com.daggertest.dependency.component;

import clean.swgreenhouse.com.daggertest.dependency.ActivityScope;
import clean.swgreenhouse.com.daggertest.dependency.module.ResourceModule;
import clean.swgreenhouse.com.daggertest.view.fragment.ResourceFragment;
import dagger.Component;

/**
 * Created by csuay on 22/09/2016.
 */
@ActivityScope
@Component(dependencies = StorageComponent.class, modules = {ResourceModule.class})
public interface ResourceComponent {
    void inject(ResourceFragment resourceFragment);
}
