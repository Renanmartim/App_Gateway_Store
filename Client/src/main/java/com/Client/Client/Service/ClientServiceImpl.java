package com.Client.Client.Service;

import com.Client.Client.Dto.BalanceRequestDto;
import com.Client.Client.Entity.ClientEntity;
import com.Client.Client.Respository.ClientRepository;
import org.springframework.http.ResponseEntity;

public interface ClientServiceImpl {

    ResponseEntity<String> addBalance(BalanceRequestDto balanceRequestDto);

    ResponseEntity<ClientEntity> createClient(ClientEntity clientEntity);

}