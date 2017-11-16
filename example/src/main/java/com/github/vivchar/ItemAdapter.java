package com.github.vivchar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.vivchar.viewfinder.ViewFinder;
import com.github.vivchar.viewfinder.ViewProvider;

import java.util.ArrayList;

/**
 * Created by Vivchar Vitaly on 17.11.17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ViewFinder> {

	@NonNull
	private final Context mContext;
	@NonNull
	private final Listener mListener;
	@NonNull
	private final ArrayList<Item> mItems = new ArrayList<>();


	public ItemAdapter(@NonNull final Context context, @NonNull final Listener listener) {
		mContext = context;
		mListener = listener;
	}

	@Override
	public ViewFinder onCreateViewHolder(final ViewGroup parent, final int viewType) {
		return new ViewFinder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
	}

	@Override
	public void onBindViewHolder(final ViewFinder viewFinder, final int position) {
		final Item item = mItems.get(position);

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

	public void setItems(@NonNull final ArrayList<Item> items) {
		mItems.clear();
		mItems.addAll(items);
		notifyDataSetChanged();
	}

	@Override
	public int getItemCount() {
		return mItems.size();
	}

	public interface Listener {
		void onItemClicked(@NonNull Item item);
	}
}
