package com.example.guest.bookclub.models;

import android.text.format.DateUtils;

import org.parceler.Parcel;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Guest on 5/2/16.
 */
@Parcel
public class Message {
    public String title;
    public String poster;
    public String content;
    public long datePosted;
    public String category;
    public List<Comment> comments;
    String pushId;


    public Message(){

    }


    public Message(String title, String poster, String content, String category){
        this.title = title;
        this.poster = poster;
        this.content = content;
        this.datePosted = System.currentTimeMillis();
        this.category = category;
        this.comments = new ArrayList<>();

    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getContent() {
        return content;
    }

    public CharSequence showDatePostedPretty() {
        return DateUtils.getRelativeTimeSpanString(datePosted);
        //return DateFormat.getDateInstance().format(datePosted);
    }

    public long getDatePosted(){ return datePosted; }

    public String getCategory() {
        return category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
