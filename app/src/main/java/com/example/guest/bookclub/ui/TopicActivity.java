package com.example.guest.bookclub.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.bookclub.Constants;
import com.example.guest.bookclub.R;
import com.example.guest.bookclub.adapters.FirebaseMessageListAdapter;
import com.example.guest.bookclub.models.Message;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopicActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.newPostButton) Button mNewPostButton;
    @Bind(R.id.categoryTextView) TextView mCategoryTextView;
    @Bind(R.id.topicPostsRecyclerView) RecyclerView mTopicPostsRecyclerView;
    String mCategory;
    private Query mQuery;
    private Firebase mFirebaseMessagesRef;
    private FirebaseMessageListAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCategory = intent.getStringExtra("selection");

        mNewPostButton.setOnClickListener(this);
        mCategoryTextView.setText(mCategory);

        mFirebaseMessagesRef = new Firebase(Constants.FIREBASE_URL_MESSAGES);
        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    private void setUpFirebaseQuery(){
        mQuery = mFirebaseMessagesRef.orderByChild("category").equalTo(mCategory);
    }

    private void setUpRecyclerView(){
        mAdapter = new FirebaseMessageListAdapter(mQuery, Message.class);
        mTopicPostsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mTopicPostsRecyclerView.setAdapter(mAdapter);
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
