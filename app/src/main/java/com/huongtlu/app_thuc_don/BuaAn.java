package com.huongtlu.app_thuc_don;

import android.view.View;

/**
 * Created by BEHUONG on 2/25/2018.
 */

public class BuaAn {
    public String name;
    private String overview;
    private int image;

    public BuaAn() {
    }
    public BuaAn(String name, String overview, int image) {
        this.name = name;
        this.overview = overview;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
