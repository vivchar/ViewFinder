package com.github.vivchar.viewfinder;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Vivchar Vitaly on 16.11.17.
 */

@SuppressWarnings("unchecked")
public class ViewFinder extends RecyclerView.ViewHolder {

	@NonNull
	private final SparseArray<View> mCachedViews = new SparseArray<>();

	public ViewFinder(@NonNull final View view) {
		super(view);
	}

	@NonNull
	public <T extends View> ViewFinder find(@IdRes final int ID, @NonNull final ViewProvider<T> viewProvider) {
		viewProvider.provide((T) findViewById(ID));
		return this;
	}

	@NonNull
	public <T extends View> T find(@IdRes final int ID) {
		return (T) findViewById(ID);
	}

	@NonNull
	public <T extends View> ViewFinder getRootView(@NonNull final ViewProvider<T> viewProvider) {
		viewProvider.provide((T) itemView);
		return this;
	}

	@NonNull
	public <T extends View> T getRootView() {
		return (T) itemView;
	}

	@NonNull
	private View findViewById(@IdRes final int ID) {
		final View cachedView = mCachedViews.get(ID);
		if (cachedView != null) {
			return cachedView;
		}
		final View view = itemView.findViewById(ID);
		mCachedViews.put(ID, view);
		return view;
	}
}