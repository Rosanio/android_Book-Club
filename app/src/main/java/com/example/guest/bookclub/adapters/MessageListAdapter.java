package com.example.guest.bookclub.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guest.bookclub.R;
import com.example.guest.bookclub.models.Message;
import com.firebase.client.core.Context;

import java.util.ArrayList;

/**
 * Created by Guest on 5/2/16.
 */
//public class MessageListAdapter extends RecyclerView.Adapter<MessageViewHolder>{
//
//    private Context mContext;
//    private ArrayList<Message> mMessages = new ArrayList<>();
//
//    public MessageListAdapter(Context context, ArrayList<Message> messages) {
//        mContext = context;
//        mMessages = messages;
//    }
//
//    @Override
//    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_list_item, parent, false);
//        MessageViewHolder viewHolder = new MessageViewHolder(view, mMessages);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(MessageViewHolder holder, int position) {
//        holder.bindMessage(mMessages.get(position));
//    }
//
//    @Override
//    public int getItemCount() {
//        return mMessages.size();
//    }
//}
