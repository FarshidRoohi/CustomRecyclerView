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
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

import farshid_roohi.ir.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.listener.OnClickTitleListener;


public class ItemParentView<Adapter extends RecyclerView.Adapter> extends LinearLayout {

    private Adapter adapter;

    private OnClickTitleListener listener;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerView        recyclerParentChild;
    private TextView            txtFirstTitle;
    private TextView            txtSecondTitle;

    private boolean isRtlLayout;
    private boolean isVisibilityProgress;
    private int     titleColor;
    private String  titleSecond;
    private String  titleFirst;
    private String  firstTitleAction;
    private String  secondTitleAction;

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

    public void setSecondTitle(String value) {
        this.titleSecond = value;

        if (this.txtSecondTitle == null) {
            return;
        }

        this.txtSecondTitle.setText(value);
    }

    public void setFirstTitle(String value) {
        this.titleFirst = value;

        if (this.txtSecondTitle == null) {
            return;
        }
        this.txtFirstTitle.setText(value);
    }

    public void setTitleColor(@ColorInt int color) {
        this.titleColor = color;
        if (this.txtSecondTitle == null || this.txtFirstTitle == null || color == 0) {
            return;
        }
        this.txtSecondTitle.setTextColor(this.titleColor);
        this.txtFirstTitle.setTextColor(this.titleColor);
    }

    public int getTitleColor() {
        return this.titleColor;
    }

    public TextView getSecondTextView() {
        return this.txtSecondTitle;
    }

    public TextView getFirstTextView() {
        return this.txtFirstTitle;
    }

    public String getTitleSecond() {
        return this.titleSecond;
    }

    public String getTitleFirst() {
        return this.titleFirst;
    }

    public String getFirstTitleAction() {
        return this.firstTitleAction;
    }

    public String getSecondTitleAction() {
        return this.secondTitleAction;
    }

    public void setTitleTextSize(@SuppressLint("SupportAnnotationUsage") @DimenRes float size) {
        if (this.txtSecondTitle == null || this.txtFirstTitle == null) {
            return;
        }
        this.txtFirstTitle.setTextSize(size);
        this.txtSecondTitle.setTextSize(size);
    }


    public Adapter getAdapter() {
        return this.adapter;
    }


    public void setVisibilityProgressBar(boolean flag) {
        this.isVisibilityProgress = flag;
    }

    public boolean getVisibilityProgressBar() {
        return this.isVisibilityProgress;
    }

    public void setTitlesListener(@Nullable final OnClickTitleListener listener) {
        this.listener = listener;
        if (this.listener == null) {
            return;
        }

        if (this.secondTitleAction != null && !this.secondTitleAction.isEmpty()) {
            this.txtFirstTitle.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onClickLeftTitleListener(secondTitleAction);
                }
            });
        }

        if (this.firstTitleAction != null && !this.firstTitleAction.isEmpty()) {
            this.txtSecondTitle.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClickRightTitleListener(firstTitleAction);
                }
            });
        }


    }

    public OnClickTitleListener getListener() {
        return this.listener;
    }


    public void setTitlesAction(@Nullable String rightTitle, @Nullable String leftTitle) {
        this.firstTitleAction = rightTitle;
        this.secondTitleAction = leftTitle;
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

            this.txtSecondTitle.setLayoutParams(paramsLeft);
            this.txtFirstTitle.setLayoutParams(paramsRight);
        }

    }

    private void initializeView() {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.item_parent_view, this, true);

        this.txtFirstTitle = view.findViewById(R.id.txt_first_title);
        this.txtSecondTitle = view.findViewById(R.id.txt_second_title);
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
