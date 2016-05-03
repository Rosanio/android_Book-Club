package com.example.guest.bookclub.models;

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
    public Date datePosted;
    public String category;
//    public List<String> topics = new ArrayList<>();

    public Message(){

    }

    public Message(String title, String poster, String content, String category){
        this.title = title;
        this.poster = poster;
        this.content = content;
//        this.topics = topics;
        this.datePosted = new Date();
        this.category = category;

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

    public String getDatePosted() {

        return DateFormat.getDateInstance().format(datePosted);
    }

    public String getCategory() {
        return category;
    }

//    public List<String> getTopics() {
//        return topics;
//    }



}
