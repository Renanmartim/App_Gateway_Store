package com.Client.Client.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ClientBuyDto {

    private String id;

    private String nameItem;

    private Long quantity;

    public ClientBuyDto(String id, String nameItem, Long quantity, Long balance) {
        this.id = id;
        this.nameItem = nameItem;
        this.quantity = quantity;
        this.balance = balance;
    }

    private Long balance;

    public String getId() {
        return id;
    }

    public String getNameItem() {
        return nameItem;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ClientBuyDto{" +
                "id='" + id + '\'' +
                ", nameItem='" + nameItem + '\'' +
                ", quantity=" + quantity +
                ", balance=" + balance +
                '}';
    }
}
