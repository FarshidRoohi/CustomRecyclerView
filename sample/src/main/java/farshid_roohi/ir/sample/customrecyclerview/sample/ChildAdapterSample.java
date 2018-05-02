package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.view.listener.OnClickTitleListener;
import farshid_roohi.ir.sample.customrecyclerview.R;


public class ChildAdapterSample extends RecyclerView.Adapter<ChildAdapterSample.ViewHolder> {

    private List<ModelSample> list;

    public ChildAdapterSample(List<ModelSample> list) {
        this.list = list;
    }

    public ChildAdapterSample() {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);

        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ModelSample item = this.list.get(position);
        holder.txtName.setText(item.getName());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private CardView cardView;

        ViewHolder(View view) {
            super(view);

            txtName = view.findViewById(R.id.txtName);
            cardView = view.findViewById(R.id.card_view);
            if (listener == null) {
                return;
            }
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClickListener(list.get(getAdapterPosition()));
                }
            });
        }

    }

    private OnClickItemListener listener;

    public void setItemLIstener(OnClickItemListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public interface OnClickItemListener {
        void onItemClickListener(ModelSample item);
    }
}
