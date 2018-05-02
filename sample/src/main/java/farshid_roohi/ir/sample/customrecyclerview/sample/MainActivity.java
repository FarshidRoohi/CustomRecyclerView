package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.sample.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.ItemContainerView;
import farshid_roohi.ir.customrecyclerview.view.ItemParentView;

public class MainActivity extends AppCompatActivity {

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
        ItemParentView     itemOne    = new ItemParentView(this);
        itemOne.setTitle("title is test");
        itemOne.setAdapter(adapterOne);
        itemParentViewList.add(itemOne);

        // populate item fake two
        ChildAdapterSample adapterTwo = new ChildAdapterSample(this.listTwo);
        ItemParentView     item2      = new ItemParentView(this);
        item2.setTitle("title is two");
        item2.setAdapter(adapterTwo);
        itemParentViewList.add(item2);

        // populate item fake three
        ChildAdapterSample adapterThree = new ChildAdapterSample(this.listThree);
        ItemParentView     item3        = new ItemParentView(this);
        item3.setTitle("title is three");
        item3.setAdapter(adapterThree);
        itemParentViewList.add(item3);

        itemContainerView.setParents(itemParentViewList);

    }

    private void populateFakeItem() {
        listOne = new ArrayList<>();
        listTwo = new ArrayList<>();
        listThree = new ArrayList<>();
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

}
