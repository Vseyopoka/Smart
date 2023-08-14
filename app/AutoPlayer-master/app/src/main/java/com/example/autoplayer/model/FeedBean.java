package com.example.autoplayer.model;

import com.example.autoplayer.enums.FeedPostType;

public class FeedBean {
    FeedPostType type;
    String url;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    String title;
    boolean mute = false;


    public FeedBean(FeedPostType type, String url) {
     
        this.type = type;
        this.url = url;

    }

    public boolean isMute() {
        return mute;
    }

    public void setMute(boolean mute) {
        this.mute = mute;
    }

    public FeedPostType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

}
