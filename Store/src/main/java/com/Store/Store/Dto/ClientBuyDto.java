package com.Store.Store.Dto;

public class ClientBuyDto {
    private String id;

    private String nameItem;

    private Long quantity;

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
