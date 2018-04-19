package farshid_roohi.ir.sample.customrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.customrecyclerview.adapter.ChildItemAdapter;
import farshid_roohi.ir.customrecyclerview.model.ChildModel;
import farshid_roohi.ir.customrecyclerview.view.ItemContainerView;
import farshid_roohi.ir.customrecyclerview.view.ParentItemView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ItemContainerView itemMainContainer = findViewById(R.id.item_container);

        List<ChildModel> listOne = new ArrayList<>();
        listOne.add(new ChildModel(0, "name 1", "title"));
        listOne.add(new ChildModel(0, "name 2", "title"));
        listOne.add(new ChildModel(0, "name 3", "title"));
        listOne.add(new ChildModel(0, "name 4", "title"));
        listOne.add(new ChildModel(0, "name 5", "title"));
        ChildItemAdapter adapter = new ChildItemAdapter(listOne);
        ParentItemView   itemOne = new ParentItemView(this);
        itemOne.addAllItem(listOne);
        itemOne.setTitle("one");


        itemMainContainer.addItem(itemOne);



    }

}
