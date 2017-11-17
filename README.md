# ViewFinder [![Release](https://jitpack.io/v/vivchar/ViewFinder.svg)](https://jitpack.io/#vivchar/ViewFinder) [![API](https://img.shields.io/badge/API-14%2B-yellow.svg?style=flat)](https://android-arsenal.com/api?level=14) [![API](https://img.shields.io/badge/Size-4%20KB-e91e63.svg)](http://www.methodscount.com/?lib=com.github.vivchar%3AViewFinder%3A1.0.0)

* Just use the ViewFinder instead of any ViewHolder;
* No more need to create a ViewHolder each time in your project;
* The ViewFinder has the same features as a ViewHolder;
* The ViewFinder can dynamically provide any link to any view;
* So you can easily add a new view type to your list.

In few words: The ViewHolder has one function - to provide a link to the view in a layout. So when you use the RecyclerView and you need to add a new View Type in your list - you must create a new ViewHolder. It is fine when you have a couple types.
But there is no need to create each time a new Holder. With this library you no need create a ViewHolder each time. The ViewFinder as a universal ViewHolder. It can provide a link to anyone view.

## Example 
```java
public class YourAdapter extends RecyclerView.Adapter<ViewFinder> {

    @Override
    public ViewFinder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewFinder(LayoutInflater.from(mContext).inflate(getLayoutID(viewType), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewFinder viewFinder, final int position) {
        final BaseItem item = mItems.get(position);

        if (item instanceof YourItem) {
            YourItem yourItem = (YourItem)item;
        
            final SwitchCompat switchCompat = viewFinder.find(R.id.item_switch);

            viewFinder
                .find(R.id.item_id, (ViewProvider<TextView>) view -> view.setText(String.valueOf(yourItem.getID())))
                .find(R.id.item_name, (ViewProvider<TextView>) view -> view.setText(yourItem.getName()))
                .find(R.id.item_logo, (ViewProvider<ImageView>) view -> view.setBackgroundResource(yourItem.getLogoResource()))
                .getRootView(view -> view.setOnClickListener(v -> {
                    switchCompat.setChecked(!switchCompat.isChecked());
                    mListener.onItemClicked(yourItem);
                }));
        } else if (item instanceof OtherItem) {
            //No need to create new ViewHolder, you just use the ViewFinder again
            //See onCreateViewHolder() method, it has only one ViewHolder 
            viewFinder.
                .find(...)
                .find(...);
        }
    }
    
    private int getLayoutID(int viewType) {
        if (viewType == YOUR_TYPE) {
            return R.layout.your_item;
        } else if (...) {
            return R.layout.other_item;
        } else if (...) {
            //...
        }
    }

    //...

}
```
## Gradle

To get this Library into your project:

### Step 1. Add the JitPack repository to your build file
```gradle
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```
### Step 2. Add the dependency
```gradle
    dependencies {
        compile 'com.github.vivchar:ViewFinder:1.0.0'
    }
```

## Try to use it too
https://github.com/vivchar/RendererRecyclerViewAdapter

## License

    Copyright 2017 Vitaly Vivchar

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
