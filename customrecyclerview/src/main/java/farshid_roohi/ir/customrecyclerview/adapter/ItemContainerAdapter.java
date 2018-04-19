package farshid_roohi.ir.customrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.ParentItemView;


public class ItemContainerAdapter extends BaseAdapterRecyclerView<ParentItemView> {

    private Context context;

    public ItemContainerAdapter(List<ParentItemView> list) {
        super(list);
    }

    public ItemContainerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getView() {
        return R.layout.item_container;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        return new ItemContainerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, ParentItemView element) {
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.itemRecyclers.setTitle(element.getTitle());
        viewHolder.itemRecyclers.addAllItem(element.getItemAdapter().getItems());
        viewHolder.itemRecyclers.setParent(element, position);
        viewHolder.progressView.setVisibility(element.getVisibilityProgressBar() ? View.VISIBLE : View.GONE);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ProgressBar    progressView;
        ParentItemView itemRecyclers;
        ViewGroup      layout;

        ViewHolder(final View view) {
            super(view);

            layout = view.findViewById(R.id.layout);
            progressView = view.findViewById(R.id.progress_view);
            itemRecyclers = new ParentItemView(context);
            layout.addView(itemRecyclers);
        }
    }
}
