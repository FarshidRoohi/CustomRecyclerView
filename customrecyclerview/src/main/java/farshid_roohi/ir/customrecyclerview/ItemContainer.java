package farshid_roohi.ir.customrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;


/**
 * Custom RecyclerView Created by Farshid on 11/13/2017.
 */


public class ItemContainer extends LinearLayout {

    private       ItemContainerAdapter     adapterContainer;
    public static RecyclerItemMainListener listener;


    public ItemContainer(Context context) {
        super(context);
    }

    public ItemContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ItemContainer(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setList(List<ParentItemAdapter> list) {
        this.adapterContainer.swapData(list);

    }

    public void addItem(ParentItemAdapter item) {
        this.adapterContainer.putItem(item);
    }

    public ItemContainerAdapter getAdapterContainer() {
        return adapterContainer;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        initializeView();
    }


    public void setListener(RecyclerItemMainListener listener) {
        ItemContainer.listener = listener;

    }


    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_container, this);
        //initialize recyclerView
        RecyclerView        recyclerViewRoot = view.findViewById(R.id.recyclerView_root);
        LinearLayoutManager manager          = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerViewRoot.setLayoutManager(manager);
        this.adapterContainer = new ItemContainerAdapter();
        recyclerViewRoot.setAdapter(this.adapterContainer);
    }


    public interface RecyclerItemMainListener {

        void onClickItemParent(ParentItemAdapter parent, int position);

        void onClickItem(ItemMainModel item, int position);
    }
}