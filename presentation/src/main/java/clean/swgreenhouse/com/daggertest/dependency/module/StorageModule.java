package clean.swgreenhouse.com.daggertest.dependency.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import clean.swgreenhouse.com.data.model.DaoMaster;
import clean.swgreenhouse.com.data.model.DaoSession;
import clean.swgreenhouse.com.data.model.ResourceDao;
import dagger.Module;
import dagger.Provides;

/**
 * Created by csuay on 22/09/2016.
 */
@Module
public class StorageModule {
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Application application;

    public StorageModule(Application context, String dbName) {
        this.application = context;
        DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(context, dbName, null);
        SQLiteDatabase db = helper.getWritableDatabase();

        this.daoMaster = new DaoMaster(db);
        this.daoSession = daoMaster.newSession();
    }

    @Provides
    @Singleton
    ResourceDao providesResourceDao() {

        return daoSession.getResourceDao();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }
}
