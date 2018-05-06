package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.os.Handler;
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

        final ItemContainerView itemContainerView = findViewById(R.id.item_container);

        List<ItemParentView> itemParentViewList = new ArrayList<>();

        // populate item fake one
        ChildAdapter         adapterOne = new ChildAdapter(this.listOne);
        final ItemParentView item1      = new ItemParentView(this);
        adapterOne.setItemListener(this);
        item1.setTitlesListener(this);
        item1.setSecondTitle("more");
        item1.setFirstTitle("title A");
        item1.setAdapter(adapterOne);
        item1.setRtlLayout(true);
        item1.setTitlesAction("action A", null);


        // populate item fake two
        ChildAdapter   adapterTwo = new ChildAdapter(this.listTwo);
        ItemParentView item2      = new ItemParentView(this);
        adapterTwo.setItemListener(this);
        item2.setTitlesListener(this);
        item2.setFirstTitle("title B");
        item2.setSecondTitle("more");
        item2.setTitlesAction("action B", null);
        item2.setAdapter(adapterTwo);

        // populate item fake three
        final ChildAdapter   adapterThree = new ChildAdapter();
        final ItemParentView item3        = new ItemParentView(this);
        adapterThree.setItemListener(this);
        item3.setTitlesListener(this);
        item3.setFirstTitle("title C");
        item3.setSecondTitle("more");
        item3.setVisibilityProgressBar(true);
        item3.setAdapter(adapterThree);
        item3.setTitlesAction("action C", null);

        // Async add item example
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                adapterThree.addList(listThree);
                item3.setVisibilityProgressBar(false);
                itemContainerView.getContainerAdapter().notifyDataSetChanged();
            }
        }, 3000);


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
