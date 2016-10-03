package clean.swgreenhouse.com.daggertest.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import clean.swgreenhouse.com.daggertest.R;
import clean.swgreenhouse.com.daggertest.dependency.component.ResourceComponent;
import clean.swgreenhouse.com.daggertest.presenter.ResourceListPresenter;
import clean.swgreenhouse.com.daggertest.view.ResourceListView;
import clean.swgreenhouse.com.daggertest.view.adapter.ResourceRecyclerViewAdapter;
import clean.swgreenhouse.com.data.model.Resource;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ResourceFragment extends BaseFragment implements ResourceListView {

    @Inject
    ResourceListPresenter resourceListPresenter;

    private OnListFragmentInteractionListener mListener;
    private ResourceRecyclerViewAdapter resourceAdapter;

    public ResourceFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resource_list, container, false);
        this.getComponent(ResourceComponent.class).inject(this);
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            resourceAdapter = new ResourceRecyclerViewAdapter(mListener);
            recyclerView.setAdapter(this.resourceAdapter);

        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.resourceListPresenter.setResourceListView(this);
        if (savedInstanceState == null) {
            this.resourceListPresenter.initialize();
        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void renderResourceList(List<Resource> resourceList) {
        resourceAdapter.setmValues(resourceList);
    }

    @Override
    public void viewResource(Resource resource) {

    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Resource item);
    }
}
