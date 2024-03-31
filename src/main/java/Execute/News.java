package Execute;

import DBC.NewsOP;

public class News {
    int id;
    String classify;
    String description;
    String image;
    String document;
    String video;

    public News(int id, String classify, String description, String image, String document, String video) {
        this.id = id;
        this.classify = classify;
        this.description = description;
        this.image = image;
        this.document = document;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public String getClassify() {
        return classify;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getDocument() {
        return document;
    }

    public String getVideo() {
        return video;
    }
}
