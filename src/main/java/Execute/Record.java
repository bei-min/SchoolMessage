package Execute;

public class Record {
    int id;
    String username;
    String email;
    String image;
    String reginTime;
    int estate;//资产
    int browse;//浏览量
    int praise;//获赞量
    int collect;//被收藏量

    public Record(int id, String username, String email, String image, String reginTime, int estate, int browse, int praise, int collect) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.image = image;
        this.reginTime = reginTime;
        this.estate = estate;
        this.browse = browse;
        this.praise = praise;
        this.collect = collect;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getImage() {
        return image;
    }

    public String getReginTime() {
        return reginTime;
    }

    public int getEstate() {
        return estate;
    }

    public int getBrowse() {
        return browse;
    }

    public int getPraise() {
        return praise;
    }

    public int getCollect() {
        return collect;
    }
}
