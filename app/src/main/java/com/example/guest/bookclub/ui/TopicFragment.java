package com.example.guest.bookclub.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.bookclub.Constants;
import com.example.guest.bookclub.R;
import com.example.guest.bookclub.adapters.FirebaseMessageListAdapter;
import com.example.guest.bookclub.models.Message;
import com.firebase.client.Firebase;
import com.firebase.client.Query;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends Fragment {
    @Bind(R.id.topicPostsRecyclerView) RecyclerView mTopicPostsRecyclerView;
    private String mCategory;
    private Query mQuery;
    private Firebase mFirebaseMessagesRef;
    private FirebaseMessageListAdapter mAdapter;


    public static TopicFragment newInstance(String category) {
        TopicFragment topicFragment = new TopicFragment();
        Bundle args = new Bundle();
        args.putString("category", category);
        topicFragment.setArguments(args);
        return topicFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategory = getArguments().getString("category");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_topic, container, false);
        ButterKnife.bind(this, view);
        mFirebaseMessagesRef = new Firebase(Constants.FIREBASE_URL_MESSAGES);
        Log.v("topic fragement", "setting up  recyclerview");
        setUpFirebaseQuery();
        setUpRecyclerView();
        return view;
    }

    private void setUpFirebaseQuery(){
        mQuery = mFirebaseMessagesRef.orderByChild("category").equalTo(mCategory);
    }

    private void setUpRecyclerView(){
        mAdapter = new FirebaseMessageListAdapter(mQuery, Message.class);
        mTopicPostsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mTopicPostsRecyclerView.setAdapter(mAdapter);
    }

}
