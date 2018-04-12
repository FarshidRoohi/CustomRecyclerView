package farshid_roohi.ir.customrecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Custom RecyclerView Created by farshid roohi on 11/28/17.
 */

public class ParentItemAdapter extends LinearLayout {

    public final String TAG = ParentItemAdapter.class.getSimpleName();

    private TextView            txtTitle;
    private boolean             flagVisibilityProgress;
    private LinearLayoutManager layoutManager;

    private ParentItemAdapter parent;
    private ItemAdapter       itemAdapter;
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

    public void addAllItem(List<ItemMainModel> myList) {
        itemAdapter.swapData(myList);
    }

    public void addItem(ItemMainModel item) {
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

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.c_parent_item, this);
        //initialize recyclerView
        RecyclerView recyclerViewItem = view.findViewById(R.id.recyclerView_item);
        this.txtTitle = view.findViewById(R.id.txt_title);
        this.itemAdapter = new ItemAdapter();
        this.layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true);
        recyclerViewItem.setLayoutManager(this.layoutManager);
        recyclerViewItem.setAdapter(this.itemAdapter);
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

    public ItemAdapter getItemAdapter() {
        return this.itemAdapter;
    }

    public LinearLayoutManager getLayoutManager() {
        return layoutManager;
    }

    public class ItemAdapter extends BaseAdapterRecyclerView<ItemMainModel> {


        public ItemAdapter(List<ItemMainModel> list) {
            super(list);
        }

        public ItemAdapter() {
        }

        @Override
        public int getView() {
            return R.layout.c_item_child_parent_container;
        }

        @Override
        public RecyclerView.ViewHolder getViewHolder(View view, int viewType) {
            return new ItemAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, int viewType, final ItemMainModel element) {
            ViewHolder viewHolder = (ItemAdapter.ViewHolder) holder;
            viewHolder.txtTitle.setText(element.getTitle());

        }

        public class ViewHolder extends RecyclerView.ViewHolder implements OnClickListener {

            final TextView txtTitle;
            CardView layout_root;

            public ViewHolder(View itemView) {
                super(itemView);


                txtTitle = itemView.findViewById(R.id.txtTitle);
                layout_root = itemView.findViewById(R.id.layout_root);
                itemView.setOnClickListener(this);
            }


            @Override
            public void onClick(View v) {

                if (ItemContainer.listener != null) {
                    ItemMainModel item = getItems().get(getAdapterPosition());
                    ItemContainer.listener.onClickItem(item, getAdapterPosition());
                    ItemContainer.listener.onClickItemParent(getParentItem(), getParentPosition());
                }

            }
        }

    }

}
