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
    public String parentMessageID;
    public String pushID;


    public Comment(){

    }

    public Comment(String author, String content, String parentMessageID){
        this.author = author;
        this.content = content;
        this.datePosted = System.currentTimeMillis();
        this.parentMessageID = parentMessageID;
    }

    public String getPushID() {
        return pushID;
    }

    public void setPushID(String pushID) {
        this.pushID = pushID;
    }

    public String getParentMessage() {
        return parentMessageID;
    }

    public String getContent() {
        return content;
    }

    public CharSequence showDatePostedPretty() {
        return DateUtils.getRelativeTimeSpanString(datePosted);
    }

    public long getDatePosted(){ return datePosted; }

    public String getAuthor() {
        return author;
    }


}
