package clean.swgreenhouse.com.data.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by csuay on 22/09/2016.
 */
@Entity(createInDb = true,
        nameInDb = "resource")
public class Resource {

    @Id
    private Long id;
    private String name;
    private String uri;
    private Boolean downloaded = false;

    @Generated(hash = 247380645)
    public Resource(Long id, String name, String uri, Boolean downloaded) {
        this.id = id;
        this.name = name;
        this.uri = uri;
        this.downloaded = downloaded;
    }

    @Generated(hash = 632359988)
    public Resource() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Boolean getDownloaded() {
        return this.downloaded;
    }

    public void setDownloaded(Boolean downloaded) {
        this.downloaded = downloaded;
    }
}
