package com.github.vivchar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private RecyclerView mRecyclerView;
	private ItemAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		mAdapter = new ItemAdapter(this,
				item -> Toast.makeText(MainActivity.this, "Clicked at " + item.getName(), Toast.LENGTH_SHORT).show()
		);

		mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
		mRecyclerView.setAdapter(mAdapter);

		reloadItems();
	}

	private void reloadItems() {
		final ArrayList<Item> items = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			items.add(new Item(i, "Item " + i, R.drawable.ic_launcher_foreground));
		}

		mAdapter.setItems(items);
	}
}
