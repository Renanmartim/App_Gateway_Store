package com.Client.Client.Service.Impl;

import com.Client.Client.Entity.ClientEntity;
import com.Client.Client.Respository.ClientRepository;
import com.Client.Client.Service.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientService implements ClientServiceImpl {

    private ClientRepository clientRepository;

    private ClientService (ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ResponseEntity<String> addBalance(String id, Long balance) {



        return ResponseEntity.ok().body(" Add autorized and complete! ");
    }
}