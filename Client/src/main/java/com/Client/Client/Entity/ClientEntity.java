package com.Client.Client.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ClientEntity {

    @Id
    private String id;

    private String name;

    private Long balance;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
