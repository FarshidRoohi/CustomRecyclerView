package farshid_roohi.ir.customrecyclerview.view.utility;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class TextUtiliys {

    public static float pxToDp(float px, Context context) {
        Resources      resources = context.getResources();
        DisplayMetrics metrics   = resources.getDisplayMetrics();
        float          dp        = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }
}
