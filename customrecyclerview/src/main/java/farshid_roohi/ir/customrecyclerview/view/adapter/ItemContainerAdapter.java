package farshid_roohi.ir.customrecyclerview.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.view.ItemParentView;

public class ItemContainerAdapter extends RecyclerView.Adapter<ItemContainerAdapter.ViewHolder> {

    private List<ItemParentView> itemParentViewList;

    private Context context;
    private int     titleColor;
    private boolean isTitleDirectionRtl;
    private float   titleSize;

    public ItemContainerAdapter(Context context) {
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemParentView itemParent;
        private ProgressBar    progressBar;

        public ViewHolder(View view) {
            super(view);

            itemParent = view.findViewById(R.id.item_parent);
            progressBar = view.findViewById(R.id.progress_view);
        }
    }

    public void putItems(List<ItemParentView> list) {
        this.itemParentViewList = list;
    }

    public void putItem(ItemParentView item) {
        if (this.itemParentViewList == null) {
            this.itemParentViewList = new ArrayList<>();
        }
        this.itemParentViewList.add(item);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.item_container_adapter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemParentView item = this.itemParentViewList.get(position);

        item.setTitleColor(this.titleColor);
        item.setRtlLayout(this.isTitleDirectionRtl);
        item.setTitleTextSize(this.titleSize);


        holder.itemParent.setSecondTitle(item.getTitleSecond());
        holder.itemParent.setFirstTitle(item.getTitleFirst());
        holder.itemParent.setAdapter(item.getAdapter());
        holder.itemParent.setTitlesAction(item.getFirstTitleAction(), item.getSecondTitleAction());
        holder.itemParent.setTitlesListener(item.getListener());
        holder.itemParent.setTitleColor(item.getTitleColor());
        holder.itemParent.setRtlLayout(item.getIsRtlLayout());
        holder.itemParent.setTitleTextSize(this.titleSize);
        holder.progressBar.setVisibility(item.getVisibilityProgressBar() ? View.VISIBLE : View.GONE);

    }

    public void setAttrs(@Nullable AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray typedArray = this.context.obtainStyledAttributes(attrs, R.styleable.ItemContainerView);

        this.titleColor = typedArray.getColor(R.styleable.ItemContainerView_titleColor, ContextCompat.getColor(this.context, R.color.color_text_tile_list));
        this.isTitleDirectionRtl = typedArray.getBoolean(R.styleable.ItemContainerView_titleDirectionRtl, false);
        this.titleSize = typedArray.getDimension(R.styleable.ItemContainerView_android_textSize, 12);
        this.titleSize = pxToDp(this.titleSize, this.context);
        typedArray.recycle();
    }

    private float pxToDp(float px, Context context) {
        Resources      resources = context.getResources();
        DisplayMetrics metrics   = resources.getDisplayMetrics();
        return (px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }


    @Override
    public int getItemCount() {
        return this.itemParentViewList.size();
    }
}
