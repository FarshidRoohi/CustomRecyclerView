package farshid_roohi.ir.sample.customrecyclerview.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.sample.customrecyclerview.R;
import farshid_roohi.ir.customrecyclerview.view.ItemContainerView;
import farshid_roohi.ir.customrecyclerview.view.ItemParentView;

public class MainActivity extends AppCompatActivity {

    private List<ModelSample> listTwo;
    private List<ModelSample> listThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listTwo = new ArrayList<>();
        listTwo.add(new ModelSample(0, "name 1", "title"));
        listTwo.add(new ModelSample(0, "name 2", "title"));
        listTwo.add(new ModelSample(0, "name 3", "title"));
        listTwo.add(new ModelSample(0, "name 4", "title"));
        listTwo.add(new ModelSample(0, "name 5", "title"));

        listThree = new ArrayList<>();
        listThree.add(new ModelSample(0, "name A", "title"));
        listThree.add(new ModelSample(0, "name B", "title"));
        listThree.add(new ModelSample(0, "name C", "title"));
        listThree.add(new ModelSample(0, "name D", "title"));
        listThree.add(new ModelSample(0, "name E", "title"));

        ItemContainerView itemContainerView = findViewById(R.id.item_container);

        List<ItemParentView> itemParentViewList = new ArrayList<>();


        ChildAdapterSample adapterOne = new ChildAdapterSample(listTwo);
        ItemParentView     itemOne    = new ItemParentView(this);
        itemOne.setTitle("title is test");
        itemOne.setAdapter(adapterOne);
        itemParentViewList.add(itemOne);

        ChildAdapterSample adapterTwo = new ChildAdapterSample(listThree);
        ItemParentView     item2      = new ItemParentView(this);
        item2.setTitle("title is two");
        item2.setAdapter(adapterTwo);

        itemParentViewList.add(item2);
        itemContainerView.setParents(itemParentViewList);

    }

}
