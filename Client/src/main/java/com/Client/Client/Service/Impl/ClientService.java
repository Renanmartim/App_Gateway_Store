package com.Client.Client.Service.Impl;

import com.Client.Client.Dto.BalanceRequestDto;
import com.Client.Client.Entity.ClientEntity;
import com.Client.Client.Respository.ClientRepository;
import com.Client.Client.Service.ClientServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class ClientService implements ClientServiceImpl {

    private ClientRepository clientRepository;

    private ClientService (ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ResponseEntity<String> addBalance(BalanceRequestDto balanceRequestDto) {

        Optional<ClientEntity> optionalClient = clientRepository.findById(balanceRequestDto.getId());

        if (optionalClient.isPresent()) {
            ClientEntity client = optionalClient.get();
            client.setBalance(client.getBalance() + balanceRequestDto.getBalance());

            var clientNew = clientRepository.save(client);
            return ResponseEntity.ok().body(" Add autorized and complete! " + "For id: " + clientNew.getId() + " New balance: " + clientNew.getBalance());
        }
        return  ResponseEntity.badRequest().body(" Id not exists! ");
    }

    @Override
    public ResponseEntity<ClientEntity> createClient(ClientEntity clientEntity) {
        var clientSaved = clientRepository.save(clientEntity);
        return ResponseEntity.ok().body(clientSaved);
    }
}