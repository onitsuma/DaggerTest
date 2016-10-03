package clean.swgreenhouse.com.daggertest.view.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import clean.swgreenhouse.com.daggertest.R;
import clean.swgreenhouse.com.daggertest.dependency.HasComponent;
import clean.swgreenhouse.com.daggertest.dependency.component.DaggerResourceComponent;
import clean.swgreenhouse.com.daggertest.dependency.component.ResourceComponent;
import clean.swgreenhouse.com.daggertest.dependency.module.ResourceModule;
import clean.swgreenhouse.com.daggertest.view.fragment.ResourceFragment;
import clean.swgreenhouse.com.data.model.Resource;

public class ResourceListActivity extends BaseActivity implements ResourceFragment.OnListFragmentInteractionListener, HasComponent<ResourceComponent> {


    private ResourceComponent resourceComponent;

    @BindView(R.id.fab)
    FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_list);
        initializeInjector();
        ButterKnife.bind(this);
        ResourceFragment fragment = new ResourceFragment();
        addFragment(R.id.resourceFragmentContainer, fragment);

    }

    @OnClick(R.id.fab)
    void clickAddButton(View view){}

    @Override
    public void onListFragmentInteraction(Resource item) {


    }


    private void initializeInjector() {
        this.resourceComponent = DaggerResourceComponent.builder()
                .storageComponent(getStorageComponent())
                .resourceModule(new ResourceModule())
                .build();
    }

    @Override
    public ResourceComponent getComponent() {
        return this.resourceComponent;
    }
}
