package farshid_roohi.ir.customrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;


public class ChildItemAdapter extends BaseAdapterRecyclerView<ChildModel> {


    public ChildItemAdapter(List<ChildModel> list) {
        super(list);
    }

    public ChildItemAdapter() {
    }

    @Override
    public int getView() {
        return R.layout.c_item_child_item;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        return new ChildItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, final ChildModel element) {
        ViewHolder viewHolder = (ChildItemAdapter.ViewHolder) holder;
        viewHolder.txtName.setText(element.getName());

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView  txtName;


        ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (ItemContainer.listener != null) {
                ChildModel item = getItems().get(getAdapterPosition());
                ItemContainer.listener.onClickItem(item, getAdapterPosition());
            }

        }
    }

}
