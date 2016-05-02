package com.example.guest.bookclub.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.bookclub.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopicActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.newPostButton) Button mNewPostButton;
    @Bind(R.id.categoryTextView) TextView mCategoryTextView;
    String mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCategory = intent.getStringExtra("selection");

        mNewPostButton.setOnClickListener(this);
        mCategoryTextView.setText(mCategory);
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.newPostButton:
                Intent intent = new Intent(TopicActivity.this, NewPostActivity.class);
                intent.putExtra("category", mCategory);
                startActivity(intent);
        }
    }
}
