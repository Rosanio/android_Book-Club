package com.example.guest.bookclub;

/**
 * Created by Guest on 5/2/16.
 */
public class Constants {

    public static final String FIREBASE_URL = BuildConfig.FIREBASE_ROOT_URL;
    public static final String FIREBASE_LOCATION_MESSAGES = "messages";
    public static final String FIREBASE_URL_MESSAGES = FIREBASE_URL + "/" + FIREBASE_LOCATION_MESSAGES;
    public static final String FIREBASE_LOCATION_CATEGORIES = "categories";
    public static final String FIREBASE_URL_CATEGORIES = FIREBASE_URL + "/" + FIREBASE_LOCATION_CATEGORIES;

    public static final String FIREBASE_LOCATION_COMMENTS = "comments";
    public static final String FIREBASE_URL_COMMENTS = FIREBASE_URL + "/" + FIREBASE_LOCATION_COMMENTS;
}
