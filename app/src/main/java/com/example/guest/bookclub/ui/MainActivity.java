package com.example.guest.bookclub.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.guest.bookclub.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.chooseTopicButton) Button mChooseTopicButton;
    @Bind(R.id.chooseTopicSpinner) Spinner mChooseTopicSpinner;
    @Bind(R.id.recentPostsRecyclerView) RecyclerView mRecentPostsRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.categories, R.layout.white_text_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mChooseTopicSpinner.setAdapter(adapter);

        mChooseTopicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selection = mChooseTopicSpinner.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, TopicActivity.class);
                intent.putExtra("selection", selection);
                startActivity(intent);
            }
        });
    }
}
