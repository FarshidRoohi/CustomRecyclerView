package farshid_roohi.ir.sample.customrecyclerview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.BaseAdapterRecyclerView;

import static farshid_roohi.ir.customrecyclerview.ItemContainer.OnClickListener;

public class ItemAdapter extends BaseAdapterRecyclerView<ItemMainModel> {

    public ItemAdapter(List<ItemMainModel> list) {
        super(list);
    }

    public ItemAdapter() {
    }

    @Override
    public int getView() {
        return R.layout.item;
    }

    @Override
    public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
        return new ItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType,
                                 final ItemMainModel element) {

        ViewHolder viewHolder = (ItemAdapter.ViewHolder) holder;
        viewHolder.txtTitle.setText(element.getTitle());

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

        final TextView txtTitle;
        CardView layout_root;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            layout_root = itemView.findViewById(R.id.layout_root);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

//            if (listener != null) {
//                ItemMainModel item = getItems().get(getAdapterPosition());
//                listener.onClickItem(item, getAdapterPosition());
//            }

        }
    }

}