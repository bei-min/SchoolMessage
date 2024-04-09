package Execute;

public class Record {
    int id;
    String username;
    String email;
    String image;
    String reginTime;
    int estate;//资产
    public Record(int id, String username, String email, String image, String reginTime, int estate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.image = image;
        this.reginTime = reginTime;
        this.estate = estate;
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

}
