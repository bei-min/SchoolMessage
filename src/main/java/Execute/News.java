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

    public News(int id, String title, int f, String imgurl, String content, String person) {
        this.id = id;
        this.title = title;
        this.f = f;
        this.imgurl = imgurl;
        this.content = content;
        this.person = person;
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
}
