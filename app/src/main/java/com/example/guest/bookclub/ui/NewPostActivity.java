package com.example.guest.bookclub.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.bookclub.Constants;
import com.example.guest.bookclub.R;
import com.example.guest.bookclub.models.Message;
import com.firebase.client.Firebase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewPostActivity extends AppCompatActivity {
    @Bind(R.id.titleEditText) EditText mTitleEditText;
    @Bind(R.id.authorEditText) EditText mAuthorEditText;
    @Bind(R.id.contentEditText) EditText mContentEditText;
    @Bind(R.id.submitButton) Button mSubmitButton;
    String mCategory;
    private int mPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mCategory = intent.getStringExtra("category");
        mPosition = Integer.parseInt(intent.getStringExtra("position"));

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mTitleEditText.getText().toString();
                String author = mAuthorEditText.getText().toString();
                String content = mContentEditText.getText().toString();
                Message message = new Message(title, author, content, mCategory);
                Firebase ref = new Firebase(Constants.FIREBASE_URL_MESSAGES);
                ref.push().setValue(message);
                Intent intent = new Intent(NewPostActivity.this, TopicActivity.class);
                intent.putExtra("selection", mCategory);
                intent.putExtra("position", mPosition+"");
                startActivity(intent);
            }
        });
    }
}
