## ViewFinder
* Just use ViewFinder instead of any ViewHolder;
* No more need to create a ViewHolder in your project;

## Example 
```
public class YourAdapter extends RecyclerView.Adapter<ViewFinder> {

    @Override
    public ViewFinder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        return new ViewFinder(LayoutInflater.from(mContext).inflate(R.layout.your_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewFinder viewFinder, final int position) {
        final YourItem item = mItems.get(position);

        final SwitchCompat switchCompat = viewFinder.find(R.id.item_switch);

        viewFinder
            .find(R.id.item_id, (ViewProvider<TextView>) view -> view.setText(String.valueOf(item.getID())))
            .find(R.id.item_name, (ViewProvider<TextView>) view -> view.setText(item.getName()))
            .find(R.id.item_logo, (ViewProvider<ImageView>) view -> view.setBackgroundResource(item.getLogoResource()))
            .getRootView(view -> view.setOnClickListener(v -> {
                switchCompat.setChecked(!switchCompat.isChecked());
                mListener.onItemClicked(item);
            }));
    }

    //...

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
