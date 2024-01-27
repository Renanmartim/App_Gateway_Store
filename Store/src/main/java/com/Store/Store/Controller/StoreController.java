package com.Store.Store.Controller;


import com.Store.Store.Dto.ClientBuyDto;
import com.Store.Store.Entity.StoreEntity;
import com.Store.Store.Service.StoreService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    private StoreService storeService;

    private StoreController (StoreService storeService){
        this.storeService = storeService;
    }
    @Value("${secret-pass}")
    private String SECRET_PASS;

    @GetMapping("/getAll")
    public ResponseEntity<List<StoreEntity>> getAll(@RequestHeader("Internal-ID") String internalId){
        if (internalId.equals(SECRET_PASS)){
            return storeService.getAll();
        } else {
            return null;
        }
    }

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestHeader("Internal-ID") String internalId, @RequestBody StoreEntity storeEntity){

        if (internalId.equals(SECRET_PASS)){
            return storeService.add(storeEntity);
        }

        return ResponseEntity.badRequest().body(" Product Not Autorized! ");
    }

    @PostMapping("/clientBuy")
    public ResponseEntity<String> clientBuy(@RequestHeader("Internal-ID") String internalId, @RequestBody ClientBuyDto clientBuyDto){
        if (internalId.equals(SECRET_PASS)){
            return storeService.buy(clientBuyDto);
        }
        return  null;
    }

}
