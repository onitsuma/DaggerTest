package clean.swgreenhouse.com.daggertest.view.fragment;

import android.app.Fragment;
import android.widget.Toast;

import clean.swgreenhouse.com.daggertest.dependency.HasComponent;

/**
 * Created by csuay on 22/09/2016.
 */
public abstract class BaseFragment extends Fragment {
    /**
     * Shows a {@link android.widget.Toast} message.
     *
     * @param message An string representing a message to be shown.
     */
    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }

}
