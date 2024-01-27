package com.Client.Client.Service.Impl;

import com.Client.Client.Dto.BalanceRequestDto;
import com.Client.Client.Dto.ClientBuyDto;
import com.Client.Client.Dto.ClientNotBalanceDto;
import com.Client.Client.Entity.ClientEntity;
import com.Client.Client.Respository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class ClientServiceImpl implements com.Client.Client.Service.ClientService {

    private ClientRepository clientRepository;

    private RestTemplate restTemplate;

    private ClientServiceImpl(ClientRepository clientRepository, RestTemplate restTemplate) {
        this.clientRepository = clientRepository;
        this.restTemplate = restTemplate;
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
    public ResponseEntity<String> subtractBalance(BalanceRequestDto balanceRequestDto) {
        Optional<ClientEntity> optionalClient = clientRepository.findById(balanceRequestDto.getId());

        if (optionalClient.isPresent()) {
            ClientEntity client = optionalClient.get();
            client.setBalance(balanceRequestDto.getBalance());

            var clientNew = clientRepository.save(client);
            return ResponseEntity.ok().body(" Subtract autorized and complete! " + "For id: " + clientNew.getId() + " New balance: " + clientNew.getBalance());
        }
        return  ResponseEntity.badRequest().body(" Id not exists! ");
    }

    @Override
    public ResponseEntity<ClientEntity> createClient(ClientEntity clientEntity) {
        var clientSaved = clientRepository.save(clientEntity);
        return ResponseEntity.ok().body(clientSaved);
    }

    @Override
    public ResponseEntity<String> buyInStore(ClientNotBalanceDto clientNotBalanceDto) {
        Optional<ClientEntity> clientOptional = clientRepository.findById(clientNotBalanceDto.getId());
        if(clientOptional.isPresent()){

            var balance = clientOptional.get().getBalance();

            ClientBuyDto clientBuyDto1 = new ClientBuyDto(clientNotBalanceDto.getId(), clientNotBalanceDto.getNameItem(), clientNotBalanceDto.getQuantity(), balance);

            System.out.println(clientBuyDto1);

            String responseObject = restTemplate.postForObject("http://localhost:8086/store/clientBuy", clientBuyDto1, String.class);

            return ResponseEntity.ok().body(responseObject);
        }
        return null;
    }
}