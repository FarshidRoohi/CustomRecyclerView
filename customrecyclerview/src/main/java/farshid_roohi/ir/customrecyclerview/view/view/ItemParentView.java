package farshid_roohi.ir.customrecyclerview.view.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DimenRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.listener.OnClickTitleListener;


public class ItemParentView<Adapter extends RecyclerView.Adapter> extends LinearLayout {

    private OnClickTitleListener listener;
    private LinearLayoutManager  linearLayoutManager;
    private RecyclerView         recyclerParentChild;
    private TextView             txtLeftTitle;
    private TextView             txtRightTitle;
    private Adapter              adapter;
    private boolean              isRtlLayout;
    private boolean              isVisibilityProgress;
    private int                  titleColor;
    private String               titleRight;
    private String               titleLeft;
    private String               rightTitleActions;
    private String               leftTitleActions;

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

    /**
     * set adapter list parent view adapter
     *
     * @param adapter
     */
    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
        this.recyclerParentChild.setAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
    }

    public void setRightTitle(String value) {
        this.titleRight = value;

        if (this.txtRightTitle == null) {
            return;
        }

        this.txtRightTitle.setText(value);
    }

    public void setLeftTitle(String value) {
        this.titleLeft = value;

        if (this.txtRightTitle == null) {
            return;
        }
        this.txtLeftTitle.setText(value);
    }

    /**
     * set title list color
     *
     * @param color
     */
    public void setTitleColor(@ColorInt int color) {
        this.titleColor = color;
        if (this.txtRightTitle == null || this.txtLeftTitle == null || color == 0) {
            return;
        }
        this.txtRightTitle.setTextColor(this.titleColor);
        this.txtLeftTitle.setTextColor(this.titleColor);
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public TextView getRightTextView() {
        return this.txtRightTitle;
    }

    public TextView getLeftTextView() {
        return this.txtLeftTitle;
    }

    public String getTitleRight() {
        return this.titleRight;
    }

    public String getTitleLeft() {
        return this.titleLeft;
    }

    public String getRightTitleActions() {
        return this.rightTitleActions;
    }

    public String getLeftTitleActions() {
        return this.leftTitleActions;
    }

    public void setTitleTextSize(@SuppressLint("SupportAnnotationUsage") @DimenRes float size) {
        if (this.txtRightTitle == null || this.txtLeftTitle == null) {
            return;
        }
        this.txtLeftTitle.setTextSize(size);
        this.txtRightTitle.setTextSize(size);
    }

    /**
     * Adapter
     *
     * @return
     */
    public Adapter getAdapter() {
        return this.adapter;
    }

    /**
     * to visibility progress bar load
     *
     * @param flag
     */
    public void setVisibilityProgressBar(boolean flag) {
        this.isVisibilityProgress = flag;
    }

    public boolean getVisibilityProgressBar() {
        return this.isVisibilityProgress;
    }

    /**
     * Click listener titles
     *
     * @param listener
     */
    public void setTitlesListener(@Nullable final OnClickTitleListener listener) {
        this.listener = listener;
        if (this.listener == null) {
            return;
        }

        this.txtLeftTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickLeftTitleListener(leftTitleActions);
            }
        });
        this.txtRightTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickRightTitleListener(rightTitleActions);
            }
        });
    }

    public OnClickTitleListener getListener() {
        return this.listener;
    }

    /**
     * set action string
     *
     * @param rightTitle
     * @param leftTitle
     */
    public void setTitlesAction(String rightTitle, String leftTitle) {
        this.rightTitleActions = rightTitle;
        this.leftTitleActions = leftTitle;
    }


    public boolean getIsRtlLayout() {
        return this.isRtlLayout;
    }

    public void setRtlLayout(boolean flag) {
        this.isRtlLayout = flag;
        if (flag) {

            this.linearLayoutManager.setReverseLayout(true);
            RelativeLayout.LayoutParams paramsLeft =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            paramsLeft.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

            RelativeLayout.LayoutParams paramsRight =
                    new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
            paramsRight.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);

            this.txtRightTitle.setLayoutParams(paramsLeft);
            this.txtLeftTitle.setLayoutParams(paramsRight);
        }

    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_parent_view, this, true);

        this.txtLeftTitle = view.findViewById(R.id.txt_left_title);
        this.txtRightTitle = view.findViewById(R.id.txt_right_title);
        this.recyclerParentChild = view.findViewById(R.id.recycler_parent_child);
        linearLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.HORIZONTAL, this.isRtlLayout);
        this.recyclerParentChild.setLayoutManager(this.linearLayoutManager);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                configClickableEffect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void configClickableEffect() throws IllegalAccessException {

        boolean availableAPI21 = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

        for (Field field : this.getClass().getDeclaredFields()) {
            if (availableAPI21 && field.getType().isAssignableFrom(TextView.class)) {
                Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.ripple_btn_toolbar);
                ((TextView) field.get(this)).setBackground(drawable);

            }
        }
    }
}
