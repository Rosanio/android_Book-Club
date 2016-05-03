package com.example.guest.bookclub.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.bookclub.R;
import com.example.guest.bookclub.models.Message;
import com.example.guest.bookclub.ui.MessageDetailActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/2/16.
 */
public class MessageViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.postTitleTextView) TextView mTitleTextView;
    @Bind(R.id.postAuthorTextView) TextView mAuthorTextView;
    @Bind(R.id.postTopicTextView) TextView mTopicTextView;

    private Context mContext;
    private ArrayList<Message> mMessages = new ArrayList<>();

    public MessageViewHolder(View itemView, ArrayList<Message> messages) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mMessages = messages;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(mContext, MessageDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("messages", Parcels.wrap(mMessages));
                mContext.startActivity(intent);
            }
        });
    }

    public void bindMessage(Message message) {

        mTitleTextView.setText(message.getTitle());
        mAuthorTextView.setText(message.getPoster());
        mTopicTextView.setText(message.getCategory());
    }
}
