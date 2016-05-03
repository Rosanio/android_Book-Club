package com.example.guest.bookclub.models;

import android.text.format.DateUtils;

import org.parceler.Parcel;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Guest on 5/2/16.
 */
@Parcel
public class Comment {

    public String author;
    public String content;
    public long datePosted;
    public Message parentMessage;


    public Comment(){

    }

    public Message getParentMessage() {
        return parentMessage;
    }

    public String getContent() {
        return content;
    }

    public CharSequence getDatePosted() {
        return DateUtils.getRelativeTimeSpanString(datePosted);
    }

    public String getAuthor() {
        return author;
    }

    public Comment(String author, String content, Message parentMessage){
        this.author = author;
        this.content = content;
        this.datePosted = System.currentTimeMillis();
        this.parentMessage = parentMessage;
    }
}
