package farshid_roohi.ir.customrecyclerview;

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


public class ParentItemAdapter extends LinearLayout {

    public final String TAG = ParentItemAdapter.class.getSimpleName();

    private OnClickItemMoreListener listener;
    private TextView                txtTitle;
    private TextView                txtMore;
    private boolean                 flagVisibilityProgress;

    private RecyclerView      recyclerViewItem;
    private ParentItemAdapter parent;
    private ChildItemAdapter  itemAdapter;
    private int               parentPosition;

    public ParentItemAdapter(Context context) {
        super(context);
        initializeView();
    }

    public ParentItemAdapter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public ParentItemAdapter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    public void addAllItem(List<ChildModel> items) {
        this.itemAdapter.swapData(items);
    }

    public void addItem(ChildModel item) {
        this.itemAdapter.putItem(item);
    }

    public void setParent(ParentItemAdapter parent, int position) {
        this.parent = parent;
        this.parentPosition = position;
    }

    public ParentItemAdapter getParentItem() {
        return this.parent;
    }

    public int getParentPosition() {
        return parentPosition;
    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.c_parent_item, this);
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
