package com.github.vivchar.viewfinder;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by Vivchar Vitaly on 16.11.17.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

	@NonNull
	private final SparseArray<View> mCachedViews = new SparseArray<>();
	@Nullable
	private ViewFinder mViewFinder;

	public ViewHolder(@NonNull final View view) {
		super(view);
	}

	@NonNull
	public ViewFinder getViewFinder() {
		if (mViewFinder == null) {
			mViewFinder = new ViewFinderImpl(itemView);
		}
		return mViewFinder;
	}
}