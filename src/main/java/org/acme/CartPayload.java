package org.acme;

public class CartPayload {



    private String title;

    private int date;



    private int quantity;

    private int price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }





    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

//    @Override
//    public String toString() {
//        return "CandidatePayload{" +
//                "fname='" + fname + '\'' +
//                ", lname='" + lname + '\'' +
//                ", age=" + age +
//                ", experience=" + experience +
//                '}';
    }


