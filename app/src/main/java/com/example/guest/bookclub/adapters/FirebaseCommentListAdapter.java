package com.example.guest.bookclub.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.bookclub.R;
import com.example.guest.bookclub.models.Comment;
import com.example.guest.bookclub.models.Message;
import com.example.guest.bookclub.util.FirebaseRecyclerAdapter;
import com.firebase.client.Query;

/**
 * Created by Guest on 5/3/16.
 */
public class FirebaseCommentListAdapter extends FirebaseRecyclerAdapter<CommentViewHolder, Comment> {

    public FirebaseCommentListAdapter(Query query, Class<Comment> itemClass){
        super(query, itemClass);
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_list_item, parent, false);
        return new CommentViewHolder(view, getItems());
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bindComment(getItem(position));
    }

    @Override
    protected void itemAdded(Comment item, String key, int position) {

    }

    @Override
    protected void itemChanged(Comment oldItem, Comment newItem, String key, int position) {

    }

    @Override
    protected void itemRemoved(Comment item, String key, int position) {

    }

    @Override
    protected void itemMoved(Comment item, String key, int oldPosition, int newPosition) {

    }
}
