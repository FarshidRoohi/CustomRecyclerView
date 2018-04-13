package farshid_roohi.ir.sample.customrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import farshid_roohi.ir.customrecyclerview.ItemContainer;
import farshid_roohi.ir.customrecyclerview.ParentItemAdapter;
import farshid_roohi.ir.customrecyclerview.listener.RecyclerItemMainListener;

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

        // ItemAdapter One
        List<ItemMainModel> list = new ArrayList<>();
        list.add(new ItemMainModel("action", "title one 1", 0));
        list.add(new ItemMainModel("action", "title one 1", 0));
        list.add(new ItemMainModel("action", "title one 1", 0));
        list.add(new ItemMainModel("action", "title one 1", 0));

        ParentItemAdapter<ItemMainModel, ItemAdapter> itemOne = new ParentItemAdapter<>(this);
        itemOne.setAdapter(new ItemAdapter(list));

        itemOne.setTitle("title one");
        this.itemMainContainer.addItem(itemOne);


//        // ItemAdapter Two
//        ParentItemAdapter<ItemMainModel, ItemAdapter> itemTwo = new ParentItemAdapter<>(this);
//        itemTwo.setTitle("two");
//        itemTwo.addItem(new ItemMainModel("action", "title", 0));
//        itemTwo.addItem(new ItemMainModel("action", "title", 0));
//        itemTwo.addItem(new ItemMainModel("action", "title", 0));
//        itemTwo.addItem(new ItemMainModel("action", "title", 0));
//        this.itemMainContainer.addItem(itemTwo);
//
//
//        // ItemAdapter Three
//        ParentItemAdapter<ItemMainModel, ItemAdapter> itemThree = new ParentItemAdapter<>(this);
//        itemThree.setTitle("three");
//        itemThree.addItem(new ItemMainModel("action", "title", 0));
//        itemThree.addItem(new ItemMainModel("action", "title", 0));
//        itemThree.addItem(new ItemMainModel("action", "title", 0));
//        itemThree.addItem(new ItemMainModel("action", "title", 0));
//        this.itemMainContainer.addItem(itemThree);

//        this.itemMainContainer.setListener(new RecyclerItemMainListener<ItemMainModel>() {
//            @Override
//            public void onClickItem(ItemMainModel item, int position) {
//                Log.i(TAG, "onClickItem: " + item.getTitle());
//            }
//        });

    }
}
