package com.example.autoplayer.utils;

import com.example.autoplayer.enums.FeedPostType;
import com.example.autoplayer.model.FeedBean;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<FeedBean> getDummyData() {
        List<FeedBean> dummyFeedList = new ArrayList<>();
        dummyFeedList.add(new FeedBean(FeedPostType.VIDEO, "https://firebasestorage.googleapis.com/v0/b/videoplayer-2e649.appspot.com/o/Porter%20Robinson%20-%20Goodbye%20To%20A%20World%20(cut)%20(Doomer%20Wave).mp4?alt=media&token=dbb3792d-0a93-4aec-9bc0-1e3544d36173.mp4"));
        dummyFeedList.add(new FeedBean(FeedPostType.VIDEO, "https://firebasestorage.googleapis.com/v0/b/videoplayer-2e649.appspot.com/o/%D0%92%D0%B5%D0%B1%D0%B8%D0%BD%D0%B0%D1%80%20%C2%AB%D0%9C%D0%B5%D0%B4%D0%B8%D0%B0%20%D0%BA%D0%B0%D0%BA%20%D0%A1DP%20%D0%BF%D0%B5%D1%80%D1%81%D0%BE%D0%BD%D0%B0%D0%BB%D0%B8%D0%B7%D0%B8%D1%80%D1%83%D0%B5%D1%82%20%D1%80%D0%B5%D0%BA%D0%BB%D0%B0%D0%BC%D1%83%20%D0%B2%20%D0%AF%D0%BD%D0%B4%D0%B5%D0%BA%D1%81%2C%20VK%2C%20MyTarget%C2%BB.mp4?alt=media&token=d2cb3534-064f-4ba0-856f-39fa5d036371.mp4"));
        dummyFeedList.add(new FeedBean(FeedPostType.VIDEO, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4"));
        dummyFeedList.add(new FeedBean(FeedPostType.VIDEO, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WhatCarCanYouGetForAGrand.mp4"));
        dummyFeedList.add(new FeedBean(FeedPostType.VIDEO, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"));
        return dummyFeedList;
    }


    public static String getDummyPlaceholder() {
        return "https://nwtangsoodo.com/wp-content/uploads/sites/191/2015/12/video-placeholder.png";
    }

}
