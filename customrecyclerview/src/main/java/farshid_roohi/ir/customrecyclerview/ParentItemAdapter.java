package farshid_roohi.ir.customrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Custom RecyclerView Created by farshid roohi on 11/28/17.
 */

public class ParentItemAdapter<T, Adapter extends BaseAdapterRecyclerView<T>> extends LinearLayout {

    public final String TAG = ParentItemAdapter.class.getSimpleName();

    private TextView            txtTitle;
    private boolean             flagVisibilityProgress;
    private LinearLayoutManager layoutManager;

    private ParentItemAdapter parent;
    private Adapter           adapter;
    private int               parentPosition;
    private RecyclerView      recyclerViewItem;

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

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        this.recyclerViewItem.setAdapter(this.adapter);
    }

    public void addAllItem(List<T> list) {
        if (this.adapter != null) {
            this.adapter.swapData(list);
        }

    }

    public void addItem(T item) {
        this.adapter.putItem(item);
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
        this.recyclerViewItem = view.findViewById(R.id.recyclerView_item);
        this.txtTitle = view.findViewById(R.id.txt_title);
        this.layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        this.recyclerViewItem.setLayoutManager(this.layoutManager);

    }

    public void setTitle(String title) {
        this.txtTitle.setVisibility(VISIBLE);
        this.txtTitle.setText(title);
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

    public Adapter getItemAdapter() {
        return this.adapter;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }
}
