package com.example.cynoteck;

public class ListItems extends RecyclerViewItems {

    private String name;
    private String id;
    private String des;
    private int image;

    public ListItems(String name, String id, String des, int image) {
        this.name = name;
        this.id = id;
        this.des = des;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
