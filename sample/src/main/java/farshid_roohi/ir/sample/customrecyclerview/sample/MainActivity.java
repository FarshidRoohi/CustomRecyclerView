package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.customrecyclerview.view.listener.OnClickTitleListener;
import farshid_roohi.ir.sample.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.view.ItemContainerView;
import farshid_roohi.ir.customrecyclerview.view.view.ItemParentView;

public class MainActivity extends AppCompatActivity implements OnClickTitleListener, ChildAdapterSample.OnClickItemListener {

    private List<ModelSample> listOne;
    private List<ModelSample> listTwo;
    private List<ModelSample> listThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateFakeItem();

        ItemContainerView itemContainerView = findViewById(R.id.item_container);

        List<ItemParentView> itemParentViewList = new ArrayList<>();

        // populate item fake one
        ChildAdapterSample adapterOne = new ChildAdapterSample(this.listOne);
        ItemParentView     item1      = new ItemParentView(this);
        adapterOne.setItemLIstener(this);
        item1.setTitlesListener(this);
        item1.setRightTitle("more");
        item1.setLeftTitle("title one");
        item1.setAdapter(adapterOne);
        item1.setTitlesAction("action1", "action2");


        // populate item fake two
        ChildAdapterSample adapterTwo = new ChildAdapterSample(this.listTwo);
        ItemParentView     item2      = new ItemParentView(this);
        adapterTwo.setItemLIstener(this);
        item2.setTitlesListener(this);
        item2.setLeftTitle("title two");
        item2.setRightTitle("more");
        item2.setAdapter(adapterTwo);

        // populate item fake three
        ChildAdapterSample adapterThree = new ChildAdapterSample(this.listThree);
        ItemParentView     item3        = new ItemParentView(this);
        adapterThree.setItemLIstener(this);
        item3.setTitlesListener(this);
        item3.setLeftTitle("title three");
        item3.setRightTitle("more");
        item3.setAdapter(adapterThree);
        item3.setTitlesAction("action1", "action2");


        // set All items in view
        itemParentViewList.add(item1);
        itemParentViewList.add(item2);
        itemParentViewList.add(item3);

        itemContainerView.setParents(itemParentViewList);

    }

    private void populateFakeItem() {

        this.listOne = new ArrayList<>();
        this.listTwo = new ArrayList<>();
        this.listThree = new ArrayList<>();

        this.listOne.add(new ModelSample(0, "A", "title"));
        this.listOne.add(new ModelSample(0, "B", "title"));
        this.listOne.add(new ModelSample(0, "C", "title"));
        this.listOne.add(new ModelSample(0, "D", "title"));
        this.listOne.add(new ModelSample(0, "E", "title"));

        this.listTwo.add(new ModelSample(0, "1", "title"));
        this.listTwo.add(new ModelSample(0, "2", "title"));
        this.listTwo.add(new ModelSample(0, "3", "title"));
        this.listTwo.add(new ModelSample(0, "4", "title"));
        this.listTwo.add(new ModelSample(0, "5", "title"));

        this.listThree.add(new ModelSample(0, "!", "title"));
        this.listThree.add(new ModelSample(0, "@", "title"));
        this.listThree.add(new ModelSample(0, "#", "title"));
        this.listThree.add(new ModelSample(0, "$", "title"));
        this.listThree.add(new ModelSample(0, "%", "title"));
    }

    @Override
    public void onClickRightTitleListener(String action) {
        Toast.makeText(this, "" + action, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickLeftTitleListener(String action) {
        Toast.makeText(this, "" + action, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClickListener(ModelSample item) {
        Toast.makeText(this, item.getName(), Toast.LENGTH_SHORT).show();
    }
}
