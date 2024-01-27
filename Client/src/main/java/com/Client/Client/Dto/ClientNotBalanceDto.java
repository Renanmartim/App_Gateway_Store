package com.Client.Client.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientNotBalanceDto {

    private String id;

    private String nameItem;

    private Long quantity;

    public ClientNotBalanceDto(String id, String nameItem, Long quantity) {
        this.id = id;
        this.nameItem = nameItem;
        this.quantity = quantity;
    }


    public String getId() {
        return id;
    }

    public String getNameItem() {
        return nameItem;
    }

    public Long getQuantity() {
        return quantity;
    }


    @Override
    public String toString() {
        return "ClientBuyDto{" +
                "id='" + id + '\'' +
                ", nameItem='" + nameItem + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
