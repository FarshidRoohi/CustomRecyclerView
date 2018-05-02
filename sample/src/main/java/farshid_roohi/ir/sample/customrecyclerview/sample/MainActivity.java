package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.customrecyclerview.view.listener.OnClickTitleListener;
import farshid_roohi.ir.sample.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.view.ItemContainerView;
import farshid_roohi.ir.customrecyclerview.view.view.ItemParentView;

public class MainActivity extends AppCompatActivity implements OnClickTitleListener, ChildAdapter.OnClickItemListener {

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
        ChildAdapter   adapterOne = new ChildAdapter(this.listOne);
        ItemParentView item1      = new ItemParentView(this);
        adapterOne.setItemLIstener(this);
        item1.setTitlesListener(this);
        item1.setRightTitle("more");
        item1.setLeftTitle("title one");
        item1.setAdapter(adapterOne);
        item1.setRtlLayout(true);
        item1.setTitlesAction("action1", "action2");


        // populate item fake two
        ChildAdapter   adapterTwo = new ChildAdapter(this.listTwo);
        ItemParentView item2      = new ItemParentView(this);
        adapterTwo.setItemLIstener(this);
        item2.setTitlesListener(this);
        item2.setLeftTitle("title two");
        item2.setRightTitle("more");
        item2.setAdapter(adapterTwo);

        // populate item fake three
        ChildAdapter   adapterThree = new ChildAdapter(this.listThree);
        ItemParentView item3        = new ItemParentView(this);
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

        itemContainerView.setItems(itemParentViewList);

    }

    private void populateFakeItem() {
        String imageUrl = "http://farshid-roohi.ir/img/sample-image.jpg";

        this.listOne = new ArrayList<>();
        this.listTwo = new ArrayList<>();
        this.listThree = new ArrayList<>();


        this.listOne.add(new ModelSample(0, "A", imageUrl));
        this.listOne.add(new ModelSample(0, "B", imageUrl));
        this.listOne.add(new ModelSample(0, "C", imageUrl));
        this.listOne.add(new ModelSample(0, "D", imageUrl));
        this.listOne.add(new ModelSample(0, "E", imageUrl));

        this.listTwo.add(new ModelSample(0, "1", imageUrl));
        this.listTwo.add(new ModelSample(0, "2", imageUrl));
        this.listTwo.add(new ModelSample(0, "3", imageUrl));
        this.listTwo.add(new ModelSample(0, "4", imageUrl));
        this.listTwo.add(new ModelSample(0, "5", imageUrl));

        this.listThree.add(new ModelSample(0, "!", imageUrl));
        this.listThree.add(new ModelSample(0, "@", imageUrl));
        this.listThree.add(new ModelSample(0, "#", imageUrl));
        this.listThree.add(new ModelSample(0, "$", imageUrl));
        this.listThree.add(new ModelSample(0, "%", imageUrl));
    }

    @Override
    public void onClickRightTitleListener(String action) {
        Toast.makeText(this, action, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickLeftTitleListener(String action) {
        Toast.makeText(this, action, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClickListener(ModelSample item) {
        Toast.makeText(this, item.getName(), Toast.LENGTH_SHORT).show();
    }
}
