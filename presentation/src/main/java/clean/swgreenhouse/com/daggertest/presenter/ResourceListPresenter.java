package clean.swgreenhouse.com.daggertest.presenter;

import javax.inject.Inject;

import clean.swgreenhouse.com.daggertest.dependency.ActivityScope;
import clean.swgreenhouse.com.daggertest.view.ResourceListView;
import clean.swgreenhouse.com.data.model.ResourceDao;

/**
 * Created by csuay on 22/09/2016.
 */
@ActivityScope
public class ResourceListPresenter implements Presenter {

    private final ResourceDao resourceDao;

    private ResourceListView resourceListView;

    @Inject
    public ResourceListPresenter(ResourceDao resourceDao) {
        this.resourceDao = resourceDao;
    }


    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void setResourceListView(ResourceListView resourceListView) {
        this.resourceListView = resourceListView;
    }

    public void initialize() {
        this.resourceListView.renderResourceList(resourceDao.loadAll());

    }
}
