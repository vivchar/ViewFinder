package com.github.vivchar.viewfinder;

import android.support.annotation.NonNull;

/**
 * Created by Vivchar Vitaly on 16.11.17.
 */
public interface ViewProvider <T> {
	void provide(@NonNull T view);
}