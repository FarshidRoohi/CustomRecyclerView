package farshid_roohi.ir.customrecyclerview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.List;

import farshid_roohi.ir.customrecyclerview.model.ChildModel;
import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.adapter.ChildItemAdapter;


public class ParentItemView extends LinearLayout {

    public final String TAG = ParentItemView.class.getSimpleName();

    private OnClickItemMoreListener listener;
    private TextView                txtTitle;
    private TextView                txtMore;
    private boolean                 flagVisibilityProgress;

    private RecyclerView     recyclerViewItem;
    private ParentItemView   parent;
    private ChildItemAdapter itemAdapter;
    private int              parentPosition;

    public ParentItemView(Context context) {
        super(context);
        initializeView();
    }

    public ParentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public ParentItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    public void addAllItem(List<ChildModel> items) {
        this.itemAdapter.swapData(items);
    }

    public void addItem(ChildModel item) {
        this.itemAdapter.putItem(item);
    }

    public void setParent(ParentItemView parent, int position) {
        this.parent = parent;
        this.parentPosition = position;
    }

    public ParentItemView getParentItem() {
        return this.parent;
    }

    public int getParentPosition() {
        return parentPosition;
    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.parent_item_view, this);
        //initialize recyclerView
        recyclerViewItem = view.findViewById(R.id.recyclerView_item);
        this.txtTitle = view.findViewById(R.id.txt_title);
        this.txtMore = view.findViewById(R.id.txt_more);
        this.itemAdapter = new ChildItemAdapter();
        this.recyclerViewItem.setAdapter(this.itemAdapter);
        this.recyclerViewItem.setLayoutManager(new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, true));
    }

    public void setTitle(String value) {
        this.txtTitle.setVisibility(VISIBLE);
        this.txtTitle.setText(value);
    }

    public void setAdapter(ChildItemAdapter adapter) {
        this.itemAdapter = adapter;
        this.recyclerViewItem.setAdapter(this.itemAdapter);
    }

    public void setMoreTitle(String value) {
        this.txtMore.setVisibility(VISIBLE);
        this.txtMore.setText(value);
    }

    public void setListenerMore(OnClickItemMoreListener listener) {
        this.listener = listener;
    }

    public void setVisibilityProgressBar(boolean flag) {
        this.flagVisibilityProgress = flag;
    }

    public boolean getVisibilityProgressBar() {
        return this.flagVisibilityProgress;
    }

    public String getTitle() {
        return this.txtTitle.getText().toString();
    }

    public ChildItemAdapter getItemAdapter() {
        return this.itemAdapter;
    }

    public interface OnClickItemMoreListener {
        void onClickItemMore();
    }
}
