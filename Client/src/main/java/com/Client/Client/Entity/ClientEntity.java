package com.Client.Client.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Getter
@Setter
public class ClientEntity {

    @Id
    private String id;

    private String name;

    private Long balance;

}
