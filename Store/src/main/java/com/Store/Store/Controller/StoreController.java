package com.Store.Store.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
public class StoreController {

    @Value("${secret-pass}")
    private String SECRET_PASS;

    @GetMapping()
    public ResponseEntity<String> getAll(@RequestHeader("Internal-ID") String internalId){
        if (internalId.equals(SECRET_PASS)){
            return ResponseEntity.ok().body(" Store autorized! ");
        }
        return ResponseEntity.badRequest().body(" Store not autorized! ");
    }

    @GetMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestHeader("Internal-ID") String internalId){

        if (internalId.equals(SECRET_PASS)){
            return ResponseEntity.ok().body(" Add Product Complete! ");
        }

        return ResponseEntity.badRequest().body(" Product Not Autorized! ");
    }

}
