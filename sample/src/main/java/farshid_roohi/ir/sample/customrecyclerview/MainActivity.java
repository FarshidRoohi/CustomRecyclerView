package farshid_roohi.ir.sample.customrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.customrecyclerview.ChildModel;
import farshid_roohi.ir.customrecyclerview.ItemContainer;
import farshid_roohi.ir.customrecyclerview.ParentItemAdapter;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();


    private ItemContainer itemMainContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.itemMainContainer = findViewById(R.id.item_container);

        this.populateItem();
    }

    private void populateItem() {

        ParentItemAdapter itemOne = new ParentItemAdapter(this);
        itemOne.setTitle("one");
        itemOne.addItem(new ChildModel(0,"name 1", "title"));
        itemOne.addItem(new ChildModel(0,"name 2", "title"));
        itemOne.addItem(new ChildModel(0,"name 3", "title"));
        itemOne.addItem(new ChildModel(0,"name 4", "title"));
        this.itemMainContainer.addItem(itemOne);

        ParentItemAdapter itemTwo = new ParentItemAdapter(this);
        itemTwo.setTitle("two");
        itemTwo.addItem(new ChildModel(0,"name 1", "title"));
        itemTwo.addItem(new ChildModel(0,"name 2", "title"));
        itemTwo.addItem(new ChildModel(0,"name 3", "title"));
        itemTwo.addItem(new ChildModel(0,"name 4", "title"));
        this.itemMainContainer.addItem(itemTwo);





    }
}
