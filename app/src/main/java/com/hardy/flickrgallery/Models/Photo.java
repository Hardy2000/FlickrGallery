package com.hardy.flickrgallery.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Photo {
/*    id: "51383487472",
    owner: "158592534@N03",
    secret: "a2d6a331c7",
    server: "65535",
    farm: 66,
    title: "LED light supplier. Contact E-mail: infocovanns@163.com Company Website: www.covanns.com",
    ispublic: 1,
    isfriend: 0,
    isfamily: 0,
    url_s: "https://live.staticflickr.com/65535/51383487472_a2d6a331c7_m.jpg",
    height_s: 180,
    width_s: 240
*/


    @SerializedName("url_s")
    @Expose
    private String url_s;

    @SerializedName("title")
    @Expose
    private String title;

    public String getUrl_s() {
        return url_s;
    }

    public void setUrl_s(String url_s) {
        this.url_s = url_s;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

