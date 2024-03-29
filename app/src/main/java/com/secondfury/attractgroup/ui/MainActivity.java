package com.secondfury.attractgroup.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.secondfury.attractgroup.presenters.MainPresenter;
import com.secondfury.attractgroup.R;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = findViewById(R.id.list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        list.setAdapter(new MainAdapter(MainPresenter.getInstance().getData(), (clickedItemIndex) -> {
            Intent fullDescriptionIntent = new Intent(MainActivity.this, FullDescriptionActivity.class);
            fullDescriptionIntent.putExtra(FullDescriptionActivity.PAGE_TO_SHOW, clickedItemIndex);
            startActivity(fullDescriptionIntent);
        }));
        EditText filter = findViewById(R.id.filter);
        filter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((MainAdapter)list.getAdapter()).filterByName(filter.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}
