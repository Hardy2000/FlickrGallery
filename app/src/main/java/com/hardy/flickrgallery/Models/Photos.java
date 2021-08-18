package com.hardy.flickrgallery.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {

/*    page: 1,
    pages: 50,
    perpage: 20,
    total: 1000,
*/

    public List<Photo> getPhoto() {
        return photo;
    }

    public void setPhoto(List<Photo> photo) {
        this.photo = photo;
    }

    @SerializedName("photo")
    @Expose
    private List<Photo> photo;

}

