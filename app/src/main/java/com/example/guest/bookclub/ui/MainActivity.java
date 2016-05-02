package com.example.guest.bookclub.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.guest.bookclub.Constants;
import com.example.guest.bookclub.R;
import com.example.guest.bookclub.adapters.FirebaseMessageListAdapter;
import com.example.guest.bookclub.models.Message;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.chooseTopicButton) Button mChooseTopicButton;
    @Bind(R.id.chooseTopicSpinner) Spinner mChooseTopicSpinner;
    @Bind(R.id.recentPostsRecyclerView) RecyclerView mRecentPostsRecyclerView;
    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;

    private Query mQuery;
    private Firebase mFirebaseMessagesRef;
    private Firebase mFirebaseCategoriesRef;
    private FirebaseMessageListAdapter mAdapter;
    public ArrayList<String> mCategories = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFirebaseMessagesRef = new Firebase(Constants.FIREBASE_URL_MESSAGES);
        mFirebaseCategoriesRef = new Firebase(Constants.FIREBASE_URL_CATEGORIES);

        mChooseTopicButton.setOnClickListener(this);
        mNewCategoryButton.setOnClickListener(this);

        setUpSpinner();

        setUpFirebaseQuery();
        setUpRecyclerView();
    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.chooseTopicButton:
                String selection = mChooseTopicSpinner.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, TopicActivity.class);
                intent.putExtra("selection", selection);
                startActivity(intent);
                break;
            case R.id.newCategoryButton:
                showNewCategoryDialog();
                break;
            default:
                break;

        }
    }

    private void showNewCategoryDialog(){
        FragmentManager fm = getSupportFragmentManager();
        AddCategoryFragment addCategoryDialogFragment = AddCategoryFragment.newInstance("Add New Category:");
        addCategoryDialogFragment.show(fm, "fragment_add_category");
    }


    private void setUpFirebaseQuery(){
        String location = mFirebaseMessagesRef.toString();
        mQuery = new Firebase(location);
    }

    private void setUpRecyclerView(){
        mAdapter = new FirebaseMessageListAdapter(mQuery, Message.class);
        mRecentPostsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecentPostsRecyclerView.setAdapter(mAdapter);
    }

    private void setUpSpinner(){
        mFirebaseCategoriesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCategories.clear();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    mCategories.add(postSnapshot.getValue().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, R.layout.white_text_spinner_item, mCategories);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mChooseTopicSpinner.setAdapter(adapter);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
