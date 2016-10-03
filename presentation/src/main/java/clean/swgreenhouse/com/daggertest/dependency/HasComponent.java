package clean.swgreenhouse.com.daggertest.dependency;

/**
 * Created by csuay on 22/09/2016.
 * Component contract
 */

public interface HasComponent<C> {
    C getComponent();
}
