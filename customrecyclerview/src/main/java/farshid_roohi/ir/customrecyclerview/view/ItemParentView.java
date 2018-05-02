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

import farshid_roohi.ir.customrecyclerview.R;


public class ItemParentView<Adapter extends RecyclerView.Adapter> extends LinearLayout {

    private RecyclerView recyclerParentChild;
    private TextView txtTitle;
    private String title;
    private Adapter              adapter;
    private boolean flagVisibilityProgress;

    public ItemParentView(Context context) {
        super(context);
        this.initializeView();
    }

    public ItemParentView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.initializeView();
    }

    public ItemParentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.initializeView();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.initializeView();
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        this.recyclerParentChild.setAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
    }

    public void setTitle(String value){
        this.title = value;
        this.txtTitle.setText(value);
    }

    public String getTitle(){
        return title;
    }
    public Adapter getAdapter(){
        return this.adapter;
    }

    public void setVisibilityProgressBar(boolean flag) {
        this.flagVisibilityProgress = flag;
    }

    public boolean getVisibilityProgressBar() {
        return this.flagVisibilityProgress;
    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_parent_view, this, true);

        this.txtTitle = view.findViewById(R.id.txt_title);
        this.recyclerParentChild = view.findViewById(R.id.recycler_parent_child);
        this.recyclerParentChild.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, true));
    }
}
