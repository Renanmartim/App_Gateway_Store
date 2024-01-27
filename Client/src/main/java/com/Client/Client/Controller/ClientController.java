package com.Client.Client.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {

    @Value("${secret-pass}")
    private String SECRET_PASS;
    @GetMapping()
    public ResponseEntity<String> getAll(@RequestHeader("Internal-ID") String internalId){
        if (internalId.equals(SECRET_PASS)){
            return ResponseEntity.ok().body(" Client autorized! ");
        }
        return ResponseEntity.badRequest().body(" Client not autorized! ");
    }

    @GetMapping("/addbalance")
    public ResponseEntity<String> add(@RequestHeader("Internal-ID") String internalId){
        if (internalId.equals(SECRET_PASS)){
            return ResponseEntity.ok().body(" Add autorized and complete! ");
        }
        return ResponseEntity.badRequest().body(" Add not autorized! ");
    }

}
