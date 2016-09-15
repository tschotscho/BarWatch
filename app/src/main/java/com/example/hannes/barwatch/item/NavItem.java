package com.example.hannes.barwatch.item;

/**
 * Created by Christopher on 18.08.2016.
 */
public class NavItem {
    private String title;
    private String subTitle;
    private int resIcon;

    public NavItem(String subTitle, String title, int resIcon) {
        this.subTitle = subTitle;
        this.title = title;
        this.resIcon = resIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }
}
