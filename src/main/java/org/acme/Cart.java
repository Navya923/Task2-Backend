package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
        import javax.persistence.Column;
        import javax.persistence.Entity;


    @Entity
    public class Cart extends PanacheEntity {

        @Column
        public String title;


        @Column
        public int quantity;

        @Column
        public int price;

        @Column
        public int date;


        @Column
        private Status status;


        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }

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

    }


