package clean.swgreenhouse.com.daggertest.view;

import java.util.List;

import clean.swgreenhouse.com.data.model.Resource;

/**
 * Created by csuay on 22/09/2016.
 */
public interface ResourceListView {

    void renderResourceList(List<Resource> resourceList);

    void viewResource(Resource resource);
}
