package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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


        ViewHolder(View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
        }
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}
