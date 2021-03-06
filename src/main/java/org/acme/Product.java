package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Product extends PanacheEntity {

    private Long id;
    private String title;

    private float price;
    private String img;


    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }



    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }


    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

}
