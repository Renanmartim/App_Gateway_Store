package com.Client.Client.Dto;

public class BalanceRequestDto {
    private String id;
    private Long balance;

    public String getId() {
        return id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
