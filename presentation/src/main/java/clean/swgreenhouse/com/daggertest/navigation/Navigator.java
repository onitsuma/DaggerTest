package clean.swgreenhouse.com.daggertest.navigation;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import clean.swgreenhouse.com.daggertest.view.activity.ResourceListActivity;

/**
 * Created by csuay on 22/09/2016.
 */
@Singleton
public class Navigator {

    @Inject
    public Navigator() {
    }

    public void navigateToResourcesList(Context context){
        if (context != null) {
            Intent intentToLaunch = new Intent(context, ResourceListActivity.class);
            context.startActivity(intentToLaunch);
        }
    }
}
