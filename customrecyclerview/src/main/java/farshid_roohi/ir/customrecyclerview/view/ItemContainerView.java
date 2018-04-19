package farshid_roohi.ir.customrecyclerview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.List;

import farshid_roohi.ir.customrecyclerview.model.ChildModel;
import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.adapter.ItemContainerAdapter;

public class ItemContainerView extends LinearLayout {

    private       ItemContainerAdapter     adapterContainer;
    public static RecyclerItemMainListener listener;

    public ItemContainerView(Context context) {
        super(context);
        initializeView();
    }

    public ItemContainerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public ItemContainerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setList(List<ParentItemView> list) {
        this.adapterContainer.swapData(list);

    }

    public void addItem(ParentItemView item) {
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
        ItemContainerView.listener = listener;

    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.container, this);
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