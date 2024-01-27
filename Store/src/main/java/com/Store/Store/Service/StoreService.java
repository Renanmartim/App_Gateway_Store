package com.Store.Store.Service;

import com.Store.Store.Dto.ClientBuyDto;
import com.Store.Store.Entity.StoreEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StoreService {

    ResponseEntity<String> add(StoreEntity storeEntity);

    ResponseEntity<List<StoreEntity>> getAll();

    ResponseEntity<String> buy(ClientBuyDto clientBuyDto);
}
