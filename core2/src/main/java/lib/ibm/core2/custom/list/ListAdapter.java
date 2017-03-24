package lib.ibm.core2.custom.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bassam on 10-12-2016.
 */

public abstract class ListAdapter<P extends ListItem, VH extends ListViewHolder> extends RecyclerView.Adapter<VH> {

    protected List<P> list;

    protected OnItemClickListener listener;

    @Override
    public int getItemCount() {

        if (list != null)
            return list.size();

        return 0;
    }

    public void setList(List<P> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position, long id, String idStr);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(getLayout(), parent, false);

        final VH vh = getViewHolder(v);

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(vh.getAdapterPosition(), vh.id, vh.idStr);
                }
            }
        });

        return vh;
    }

    protected abstract int getLayout();

    protected abstract VH getViewHolder(View v);

}
