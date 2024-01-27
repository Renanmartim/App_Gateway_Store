package com.Store.Store.Service.Impl;

import com.Store.Store.Dto.BalanceRequestDto;
import com.Store.Store.Dto.ClientBuyDto;
import com.Store.Store.Entity.StoreEntity;
import com.Store.Store.Repository.StoreRepository;
import com.Store.Store.Service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private RestTemplate restTemplate;

    private StoreRepository storeRepository;

    private StoreServiceImpl(StoreRepository storeRepository, RestTemplate restTemplate){
        this.storeRepository = storeRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public ResponseEntity<String> add(StoreEntity storeEntity) {
        var store = storeRepository.save(storeEntity);
        return ResponseEntity.ok().body(" New Item Added Successfully! ");
    }

    @Override
    public ResponseEntity<List<StoreEntity>> getAll() {
        var all = storeRepository.findAll();
        return ResponseEntity.ok().body(all);
    }

    @Override
    public ResponseEntity<String> buy(ClientBuyDto clientBuyDto) {

        System.out.println(clientBuyDto);

        Optional<StoreEntity> getName = storeRepository.findBynameItem(clientBuyDto.getNameItem());

        if(getName.isPresent()){

            StoreEntity storeEntity = getName.get();

            if(clientBuyDto.getBalance() < (storeEntity.getPrice() * clientBuyDto.getQuantity())){
                return ResponseEntity.ok().body(" Balance Insufficient, Add More!");
            } else{

                if(clientBuyDto.getQuantity() > storeEntity.getQuantity()) {

                    return ResponseEntity.ok().body(" Quantity Is Not Disponible! ");

                }else {
                    storeEntity.setQuantity(storeEntity.getQuantity() - clientBuyDto.getQuantity());

                    System.out.println(clientBuyDto.getBalance());

                    var balanceNew = clientBuyDto.getBalance() - (storeEntity.getPrice() * storeEntity.getQuantity());

                    var absoluteBalance = Math.abs(balanceNew);

                    System.out.println(absoluteBalance);

                    BalanceRequestDto balanceRequestDto = new BalanceRequestDto(clientBuyDto.getId(), absoluteBalance);

                    String responseObject = restTemplate.postForObject("http://localhost:8086/client/subtractbalance", balanceRequestDto, String.class);

                    System.out.println(responseObject);

                    storeRepository.save(storeEntity);

                    return ResponseEntity.ok().body(" Successful Purchase | For Client: " + clientBuyDto.getId() + " New Balance: " + clientBuyDto.getBalance());
                }

            }


        }

        return ResponseEntity.ok().body("Item not found in the store.");
    }
}
