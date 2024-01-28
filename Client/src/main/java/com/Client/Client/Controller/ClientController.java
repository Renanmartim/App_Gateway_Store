package com.Client.Client.Controller;


import com.Client.Client.Dto.BalanceRequestDto;
import com.Client.Client.Dto.ClientBuyDto;
import com.Client.Client.Dto.ClientNotBalanceDto;
import com.Client.Client.Entity.ClientEntity;
import com.Client.Client.Service.Impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class ClientController {


    private ClientServiceImpl clientService;
    private ClientController(ClientServiceImpl clientService){
        this.clientService = clientService;

    }

    @Value("${secret-pass}")
    private String SECRET_PASS;

    @PostMapping("/addbalance")
    public ResponseEntity<String> add(@RequestHeader("Internal-ID") String internalId, @RequestBody BalanceRequestDto balanceRequestDto){
        if (internalId.equals(SECRET_PASS)){
            return clientService.addBalance(balanceRequestDto);
        }
        return ResponseEntity.badRequest().body(" Add not autorized! ");
    }

    @PostMapping("/subtractbalance")
    public ResponseEntity<String> subtract(@RequestHeader("Internal-ID") String internalId, @RequestBody BalanceRequestDto balanceRequestDto){
        if (internalId.equals(SECRET_PASS)){
            return clientService.subtractBalance(balanceRequestDto);
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

    @PostMapping("/clientpurshase")
    public ResponseEntity<String> purshase(@RequestHeader("Internal-ID") String internalId, @RequestBody ClientNotBalanceDto clientNotBalanceDto){
        if (internalId.equals(SECRET_PASS)){
            return clientService.buyInStore(clientNotBalanceDto);
        }
        return ResponseEntity.badRequest().body(" Not autorized! ");
    }

}
