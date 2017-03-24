package lib.ibm.core2.custom.list;

/**
 * Created by bassam on 10-12-2016.
 */

public abstract class ListItem {

    private long id;
    private String idStr;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdStr() {
        return idStr;
    }

    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }
}
