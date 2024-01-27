package com.Client.Client.Controller;


import com.Client.Client.Dto.BalanceRequestDto;
import com.Client.Client.Entity.ClientEntity;
import com.Client.Client.Service.Impl.ClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {


    private ClientService clientService;
    private ClientController(ClientService clientService){
        this.clientService = clientService;

    }

    @Value("${secret-pass}")
    private String SECRET_PASS;
    @GetMapping()
    public ResponseEntity<String> getAll(@RequestHeader("Internal-ID") String internalId){
        if (internalId.equals(SECRET_PASS)){
            return ResponseEntity.ok().body(" Client autorized! ");
        }
        return ResponseEntity.badRequest().body(" Client not autorized! ");
    }

    @PostMapping("/addbalance")
    public ResponseEntity<String> add(@RequestHeader("Internal-ID") String internalId, @RequestBody BalanceRequestDto balanceRequestDto){
        if (internalId.equals(SECRET_PASS)){
            return clientService.addBalance(balanceRequestDto);
        }
        return ResponseEntity.badRequest().body(" Add not autorized! ");
    }

    @PostMapping("/createUser")
    public ResponseEntity<ClientEntity> create(@RequestHeader("Internal-ID") String internalId, @RequestBody ClientEntity clientEntity){
        if (internalId.equals(SECRET_PASS)){
            var client = clientService.createClient(clientEntity);
            return client;
        }
        return  null;
    }

}
