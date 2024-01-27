package com.Store.Store.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Document
public class StoreEntity {

    @Id
    private String id;

    private String nameItem;

    private Long price;

    private Long quantity;

    public String getId() {
        return id;
    }

    public String getNameItem() {
        return nameItem;
    }

    public Long getPrice() {
        return price;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
