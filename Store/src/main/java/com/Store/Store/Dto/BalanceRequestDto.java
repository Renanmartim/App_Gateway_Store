package com.Store.Store.Dto;
public class BalanceRequestDto {

    private String id;
    private Long balance;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public BalanceRequestDto(String id, Long balance) {
        this.id = id;
        this.balance = balance;
    }
}
