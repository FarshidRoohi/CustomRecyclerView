package farshid_roohi.ir.customrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

/**
 * Custom RecyclerView Created by farshid roohi on 11/28/17.
 */

public class ItemContainerAdapter extends BaseAdapterRecyclerView<ParentItemAdapter> {


    public ItemContainerAdapter(List<ParentItemAdapter> list) {
        super(list);
    }

    public ItemContainerAdapter(){
    }

    @Override
    public int getView() {
        return R.layout.item_list_recycler_main;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        return new ItemContainerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, ParentItemAdapter element) {
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.itemRecyclers.setTitle(element.getTitle());
        viewHolder.itemRecyclers.addAllItem(element.getItemAdapter().getItems());
        viewHolder.itemRecyclers.setParent(element, position);

        viewHolder.progressView.setVisibility(element.getVisibilityProgressBar() ? View.VISIBLE : View.GONE);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ParentItemAdapter itemRecyclers;
        ProgressBar       progressView;

        public ViewHolder(final View view) {
            super(view);

            itemRecyclers = view.findViewById(R.id.item_recycler);
            progressView = view.findViewById(R.id.progress_view);
        }
    }
}
