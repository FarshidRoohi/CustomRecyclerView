package farshid_roohi.ir.customrecyclerview.view;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.adapter.ItemContainerAdapter;

public class ItemContainerView extends LinearLayout {

    private ItemContainerAdapter containerAdapter;
    private AttributeSet         attrs;


    public ItemContainerView(Context context) {
        super(context);
        this.initializeView();
    }

    public ItemContainerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.attrs = attrs;
        this.initializeView();
    }


    public ItemContainerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.attrs = attrs;
    }

    public void setItems(List<ItemParentView> values) {
        this.containerAdapter.putItems(values);
        this.containerAdapter.notifyDataSetChanged();
    }

    public void putItem(ItemParentView value) {
        this.containerAdapter.putItem(value);
        this.containerAdapter.notifyDataSetChanged();
    }

    public ItemContainerAdapter getContainerAdapter() {
        return this.containerAdapter;
    }
    public void notifyDataSetChanged(){
        this.containerAdapter.notifyDataSetChanged();
    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_container, this, true);

        RecyclerView recyclerContainer = view.findViewById(R.id.recycler_container);
        recyclerContainer.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        this.containerAdapter = new ItemContainerAdapter(getContext());
        this.containerAdapter.setAttrs(this.attrs);
        recyclerContainer.setAdapter(this.containerAdapter);

    }
}
