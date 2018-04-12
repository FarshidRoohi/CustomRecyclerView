package farshid_roohi.ir.sample.customrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import farshid_roohi.ir.customrecyclerview.ItemContainer;
import farshid_roohi.ir.customrecyclerview.ItemMainModel;
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

        // ItemAdapter One
        final ParentItemAdapter itemZarinak = new ParentItemAdapter(this);

        itemZarinak.setTitle("one");
        itemZarinak.addItem(new ItemMainModel("action", "title", 0));
        itemZarinak.addItem(new ItemMainModel("action", "title 22", 0));
        itemZarinak.addItem(new ItemMainModel("action", "title", 0));
        this.itemMainContainer.addItem(itemZarinak);


        // ItemAdapter Two
        final ParentItemAdapter itemPayment = new ParentItemAdapter(this);
        itemPayment.setTitle("two");
        itemPayment.addItem(new ItemMainModel("action", "title", 0));
        itemPayment.addItem(new ItemMainModel("action", "title", 0));
        itemPayment.addItem(new ItemMainModel("action", "title", 0));
        itemPayment.addItem(new ItemMainModel("action", "title", 0));
        this.itemMainContainer.addItem(itemPayment);

        // ItemAdapter Three
        final ParentItemAdapter itemThree = new ParentItemAdapter(this);
        itemThree.setTitle("three");
        itemThree.addItem(new ItemMainModel("action", "title", 0));
        itemThree.addItem(new ItemMainModel("action", "title", 0));
        itemThree.addItem(new ItemMainModel("action", "title", 0));
        itemThree.addItem(new ItemMainModel("action", "title", 0));
        this.itemMainContainer.addItem(itemThree);

        this.itemMainContainer.setListener(new ItemContainer.RecyclerItemMainListener() {
            @Override
            public void onClickItemParent(ParentItemAdapter parent, int position) {
            }

            @Override
            public void onClickItem(ItemMainModel item, int position) {
                Log.i(TAG, "onClickItemParent: " + item.getTitle());

            }
        });

    }
}
