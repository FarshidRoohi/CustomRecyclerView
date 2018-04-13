package farshid_roohi.ir.customrecyclerview;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseAdapterRecyclerView<T> extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<T> list;

    public BaseAdapterRecyclerView(List<T> list) {
        this.list = list;
    }

    public BaseAdapterRecyclerView() {
        this.list = new ArrayList<>();
    }

    @LayoutRes
    public abstract int getView();

    public abstract RecyclerView.ViewHolder getViewHolder(View view, int ViewType);

    public abstract void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, T item);


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(getView(), parent, false);

        return getViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder(holder, position, holder.getItemViewType(), this.list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list == null ? 0 : this.list.size();
    }

    public List<T> getItems() {
        return this.list;
    }

    public RecyclerView.Adapter getAdapter() {
        return this;
    }

    @SafeVarargs
    public final void putItem(T... items) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(new ArrayList<>(Arrays.asList(items)));

        notifyDataSetChanged();
    }

    public void putItem(int position, T item) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(position, item);
        notifyDataSetChanged();
    }

    public void swapData(List<T> list) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void removeAll() {
        if (this.list == null) {
            return;
        }
        this.list.clear();
        notifyDataSetChanged();
    }

    public void removeItem(T... items) {
        if (this.list == null) {
            return;
        }
        this.list.removeAll(new ArrayList<>(Arrays.asList(items)));
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        if (this.list == null && this.list.size() < position) {
            return;
        }
        this.list.remove(position);
        notifyDataSetChanged();
    }
}
