package com.Client.Client.Service;

import com.Client.Client.Entity.ClientEntity;
import org.springframework.http.ResponseEntity;

public interface ClientServiceImpl {

    ResponseEntity<String> addBalance(String id, Long balance);

}