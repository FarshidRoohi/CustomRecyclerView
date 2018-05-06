# Custom RecyclerView simple Google play 

  ![API](https://img.shields.io/badge/API-14%2B-blue.svg?style=flat)

  - Simple  Google play RecyclerView
  - Support right to left title and reverse RecyclerView items (Persian Language)



 ###### via Gradle: 

```Gradle
   implementation 'ir.farshid_roohi:customrecyclerview:0.1.2'
```
###### or Maven:
 ```Maven
 <dependency>
   <groupId>ir.farshid_roohi</groupId>
   <artifactId>customrecyclerview</artifactId>
   <version>0.1.1</version>
   <type>pom</type>
 </dependency>
 ```

##### screenShot: 

<img src="https://raw.githubusercontent.com/FarshidRoohi/CustomRecyclerView/master/art/img.png" alt="screen show" width="270px" height="500px">

### example: 

```XML
        <farshid_roohi.ir.customrecyclerview.view.view.ItemContainerView
            android:id="@+id/item_container"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:textSize="15sp"
            app:titleColor="@color/color_titles"
            app:titleDirectionRtl="false" />

```
#### async sample:

```Java
 // populate item fake three
        final ChildAdapter   adapterThree = new ChildAdapter();
        final ItemParentView item3        = new ItemParentView(this);
        adapterThree.setItemListener(this);
        item3.setTitlesListener(this);
        item3.setFirstTitle("title");
        item3.setSecondTitle("more");
        item3.setVisibilityProgressBar(true);
        item3.setAdapter(adapterThree);
        item3.setTitlesAction("action", null);

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
          itemParentViewList.add(item3);
        
          itemContainerView.setItems(itemParentViewList);
```
<hr>
##### see complete samples : <a href="https://github.com/FarshidRoohi/CustomRecyclerView/tree/master/sample">sample</a>
