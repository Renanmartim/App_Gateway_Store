package com.Client.Client.Service;

import com.Client.Client.Dto.BalanceRequestDto;
import com.Client.Client.Dto.ClientBuyDto;
import com.Client.Client.Dto.ClientNotBalanceDto;
import com.Client.Client.Entity.ClientEntity;
import org.springframework.http.ResponseEntity;

public interface ClientService {

    ResponseEntity<String> addBalance(BalanceRequestDto balanceRequestDto);

    ResponseEntity<String> subtractBalance(BalanceRequestDto balanceRequestDto);

    ResponseEntity<ClientEntity> createClient(ClientEntity clientEntity);

    ResponseEntity<String> buyInStore(ClientNotBalanceDto clientNotBalanceDto);

}