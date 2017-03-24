package lib.ibm.core2.custom.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by bassam on 11-12-2016.
 */

public abstract class ListViewHolder extends RecyclerView.ViewHolder {

    public long id;
    public String idStr;

    public ListViewHolder(View itemView) {
        super(itemView);
    }
}
