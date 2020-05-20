package com.example.cynoteck;

public class Header extends RecyclerViewItems {

    private String HeaderText;

    public Header(String headerText) {
        HeaderText = headerText;
    }

    public String getHeaderText() {
        return HeaderText;
    }

    public void setHeaderText(String headerText) {
        HeaderText = headerText;
    }
}
