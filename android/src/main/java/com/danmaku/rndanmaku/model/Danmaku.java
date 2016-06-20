package com.danmaku.rndanmaku.model;

/**
 * Created by mygu on 16/6/20.
 */
public class Danmaku {
    public long id;
    public int userId;
    public String type;
    public int avatarUrl;
    public String content;

    public Danmaku(long id, int userId, String type, int avatarUrl, String content) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.content = content;
    }
}
