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

public class ItemContainer extends LinearLayout {

    private       ItemContainerAdapter     adapterContainer;
    public static RecyclerItemMainListener listener;

    public ItemContainer(Context context) {
        super(context);
        initializeView();
    }

    public ItemContainer(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
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
//        initializeView();
    }


    public void serListener(RecyclerItemMainListener listener) {
        ItemContainer.listener = listener;

    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_container, this);
        //initialize recyclerView
        RecyclerView recyclerViewRoot = view.findViewById(R.id.recyclerView_root);
        recyclerViewRoot.setScrollContainer(false);
        recyclerViewRoot.setNestedScrollingEnabled(false);
        this.adapterContainer = new ItemContainerAdapter(getContext());
        recyclerViewRoot.setAdapter(this.adapterContainer);
        recyclerViewRoot.setLayoutManager(new LinearLayoutManager(getContext()
                ,LinearLayoutManager.VERTICAL,false));

    }

    public interface RecyclerItemMainListener {
        void onClickItem(ChildModel item, int position);
    }
}