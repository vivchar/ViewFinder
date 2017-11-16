package com.github.vivchar;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Created by Vivchar Vitaly on 17.11.17.
 */

public class Item {

	private final int mID;
	@NonNull
	private final String mName;
	@DrawableRes
	private int mLogoResource;

	public Item(final int ID, @NonNull final String name, @DrawableRes final int logoResource) {
		mID = ID;
		mName = name;
		mLogoResource = logoResource;
	}

	public int getID() {
		return mID;
	}

	@NonNull
	public String getName() {
		return mName;
	}

	@DrawableRes
	public int getLogoResource() {
		return mLogoResource;
	}
}
