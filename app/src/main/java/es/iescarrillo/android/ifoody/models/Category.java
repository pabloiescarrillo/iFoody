package es.iescarrillo.android.ifoody.models;

import java.io.Serializable;

public class Category implements Serializable {

    // En title vamos a guardar el nombre de la category
    private String title;
    // En image vamos a guardar el nombre de la imagen
    private int image;

    public Category(){
        super();
    }

    public Category(String title, int image){
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
