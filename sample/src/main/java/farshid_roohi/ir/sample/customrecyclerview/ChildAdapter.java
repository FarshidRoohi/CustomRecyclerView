package farshid_roohi.ir.sample.customrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.adapter.BaseAdapterRecyclerView;


public class ChildAdapter extends BaseAdapterRecyclerView<Model> {


    public ChildAdapter(List<Model> list) {
        super(list);
    }

    public ChildAdapter() {
    }

    @Override
    public int getView() {
        return R.layout.item_view;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        return new ChildAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, final Model element) {
        ViewHolder viewHolder = (ChildAdapter.ViewHolder) holder;
        viewHolder.txtName.setText(element.getName());

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;


        ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
        }
    }

}
