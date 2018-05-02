package farshid_roohi.ir.customrecyclerview.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.view.ItemParentView;

public class ItemContainerAdapter extends RecyclerView.Adapter<ItemContainerAdapter.ViewHolder> {

    private List<ItemParentView> itemParentViewList;

    private Context context;

    public ItemContainerAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemParentView itemParent;
        private ProgressBar    progressBar;

        public ViewHolder(View view) {
            super(view);

            itemParent = view.findViewById(R.id.item_parent);
            progressBar = view.findViewById(R.id.progress_view);
        }
    }

    public void putItems(List<ItemParentView> list) {
        this.itemParentViewList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_container_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemParentView item = this.itemParentViewList.get(position);
        holder.itemParent.setRightTitle(item.getTitleRight());
        holder.itemParent.setLeftTitle(item.getTitleLeft());
        holder.itemParent.setAdapter(item.getAdapter());
        holder.itemParent.setTitlesAction(item.getRightTitleActions(), item.getLeftTitleActions());
        holder.itemParent.setTitlesListener(item.getListener());
        holder.itemParent.setTitleColor(item.getTitleColor());

        holder.progressBar.setVisibility(item.getVisibilityProgressBar() ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return this.itemParentViewList.size();
    }
}
