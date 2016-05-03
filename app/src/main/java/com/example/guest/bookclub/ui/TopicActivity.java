package com.example.guest.bookclub.ui;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.guest.bookclub.Constants;
import com.example.guest.bookclub.R;
import com.example.guest.bookclub.adapters.CategoryPagerAdapter;
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

public class TopicActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.newPostButton) Button mNewPostButton;
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private CategoryPagerAdapter adapterViewPager;
    int index;
    String mCategory;
    ArrayList<String> mCategories = new ArrayList<>();
    private Query mQuery;
    private Firebase mFirebaseCategoriesRef;
    private FirebaseMessageListAdapter mAdapter;
    private ValueEventListener mFirebaseCategoriesRefListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        //mCategory = intent.getStringExtra("selection");

        mNewPostButton.setOnClickListener(this);

        mFirebaseCategoriesRef = new Firebase(Constants.FIREBASE_URL_CATEGORIES);
        mFirebaseCategoriesRefListener = mFirebaseCategoriesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mCategories.clear();
                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    mCategories.add(postSnapshot.getValue().toString());
                }
                int startingPosition = Integer.parseInt(getIntent().getStringExtra("position"));
                Log.v("startingPosition: ", "" + startingPosition);
                adapterViewPager = new CategoryPagerAdapter(getSupportFragmentManager(), mCategories);
                mViewPager.setAdapter(adapterViewPager);
                mViewPager.setCurrentItem(startingPosition);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


    }

//    private void setUpFirebaseQuery(){
//        mQuery = mFirebaseCategoriesRef;
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseCategoriesRef.removeEventListener(mFirebaseCategoriesRefListener);
    }



    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.newPostButton:
                index = mViewPager.getCurrentItem();
                String category = mCategories.get(index);
                Intent intent = new Intent(TopicActivity.this, NewPostActivity.class);
                intent.putExtra("category", category);
                intent.putExtra("position", index + "");
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
