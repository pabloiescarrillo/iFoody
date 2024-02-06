package es.iescarrillo.android.ifoody.models;

import java.io.Serializable;

public class Category implements Serializable {
    private String title;
    private String image;

    public Category() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
