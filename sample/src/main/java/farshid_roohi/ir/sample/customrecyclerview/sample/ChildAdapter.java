package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.sample.customrecyclerview.R;


public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ViewHolder> {

    private List<ModelSample> list;

    public ChildAdapter(List<ModelSample> list) {
        this.list = list;
    }

    public ChildAdapter() {
        this.list = new ArrayList<>();
    }


    public void addList(List<ModelSample> list) {
        this.list = list;
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
        Picasso.get()
                .load(item.getImageUrl())
                .into(holder.img);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView  cardView;
        private ImageView img;
        private TextView  txtName;

        ViewHolder(View view) {
            super(view);

            cardView = view.findViewById(R.id.card_view);
            img = view.findViewById(R.id.img);
            txtName = view.findViewById(R.id.txt_name);
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

    public void setItemListener(OnClickItemListener listener) {
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
