package Execute;

import DBC.NewsOP;

import java.util.ArrayList;

public class News {
    int id;
    String title;
    int f;
    String imgurl;
    String content;
    String person;
    String classify;
    int point;

    public News(int id, String title, int f, String imgurl, String content, String person, String classify, int point) {
        this.id = id;
        this.title = title;
        this.f = f;
        this.imgurl = imgurl;
        this.content = content;
        this.person = person;
        this.classify = classify;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getF() {
        return f;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getContent() {
        return content;
    }

    public String getPerson() {
        return person;
    }

    public String getClassify() {
        return classify;
    }

    public int getPoint() {
        return point;
    }
}
