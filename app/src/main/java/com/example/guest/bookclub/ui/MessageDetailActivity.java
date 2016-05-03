package com.example.guest.bookclub.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.guest.bookclub.R;
import com.example.guest.bookclub.models.Message;

import org.parceler.Parcel;
import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MessageDetailActivity extends AppCompatActivity implements AddCommentFragment.AddCommentDialogListener {
    private Message mMessage;
    @Bind(R.id.titleTextView) TextView mTitleTextView;
    @Bind(R.id.authorTextView) TextView mAuthorTextView;
    @Bind(R.id.dateTextView) TextView mDateTextView;
    @Bind(R.id.topicTextView) TextView mTopicTextView;
    @Bind(R.id.contentTextView) TextView mContentTextView;
    @Bind(R.id.commentsRecyclerView) RecyclerView mCommentsRecyclerView;
    @Bind(R.id.newCommentButton) Button mNewCommentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mMessage = Parcels.unwrap(intent.getParcelableExtra("message"));
        mTitleTextView.setText(mMessage.getTitle());
        mAuthorTextView.setText(mMessage.getPoster());
        mDateTextView.setText(mMessage.getDatePosted());
        mTopicTextView.setText(mMessage.getCategory());
        mContentTextView.setText(mMessage.getContent());

        mNewCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNewCommentDialog();
            }
        });
    }

    private void showNewCommentDialog(){
        FragmentManager fm = getSupportFragmentManager();
        AddCommentFragment addCommentDialogFragment = AddCommentFragment.newInstance("Add New Comment:");
        addCommentDialogFragment.show(fm, "fragment_add_comment");
    }

    @Override
    public void onFinishEditDialog(String authorText, String contentText){
//        mFirebaseCommentsRef.push().setValue(inputText);
        Toast.makeText(this, "comment author: " + authorText + " body: " + contentText, Toast.LENGTH_SHORT).show();
    }
}
// TODO: create dialog for adding comment, save button, retrieve comments for message specifically and display via adapter