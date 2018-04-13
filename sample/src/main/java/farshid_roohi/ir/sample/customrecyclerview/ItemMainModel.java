package farshid_roohi.ir.sample.customrecyclerview;


/**
 * Custom RecyclerView Created by Farshid on 11/8/2017.
 */

public class ItemMainModel {

    private String actionId;
    private String title;
    private int    icon;
    private int    color;
    private int    tintColor;


    public ItemMainModel(String actionId, String title, int icon) {
        this.title = title;
        this.icon = icon;
        this.actionId = actionId;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getTintColor() {
        return tintColor;
    }

    public void setTintColor(int tintColor) {
        this.tintColor = tintColor;
    }
}
