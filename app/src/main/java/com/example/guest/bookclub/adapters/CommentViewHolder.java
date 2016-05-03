package com.example.guest.bookclub.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.guest.bookclub.R;
import com.example.guest.bookclub.models.Comment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 5/3/16.
 */
public class CommentViewHolder extends RecyclerView.ViewHolder {
    @Bind(R.id.commentAuthorTextView) TextView mCommentAuthorTextView;
    @Bind(R.id.commentContentTextView) TextView mCommentContentTextView;
    @Bind(R.id.commentDateTextView) TextView mCommentDateTextView;

    private Context mContext;
    private ArrayList<Comment> mComments = new ArrayList<>();
    private Comment mComment;

    public CommentViewHolder(View itemView, ArrayList<Comment> comments){
        super(itemView);
        ButterKnife.bind(this, itemView);
        mContext = itemView.getContext();
        mComments = comments;

    }

    public void bindComment(Comment comment){
        mCommentAuthorTextView.setText(comment.getAuthor());
        mCommentContentTextView.setText(comment.getContent());
        mCommentDateTextView.setText(comment.showDatePostedPretty());
    }
}
