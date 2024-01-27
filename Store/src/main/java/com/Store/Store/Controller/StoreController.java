package com.Store.Store.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("store")
public class StoreController {

    @Value("${secret-pass}")
    private String SECRET_PASS;

    @GetMapping()
    public String getAll(@RequestHeader("Internal-ID") String internalId){
        if (internalId.equals(SECRET_PASS)){
            return " Store autorized! ";
        }
        return " Store not autorized! ";
    }

    @GetMapping("/addProduct")
    public String addProduct(){
        return " Add Product! ";
    }

}
