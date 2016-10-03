package clean.swgreenhouse.com.daggertest.dependency;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by csuay on 22/09/2016.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {


}
