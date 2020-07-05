package com.rentingapp.rentcar.modules.client;

import com.rentingapp.rentcar.modules.client.entity.Client;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RequiredArgsConstructor
@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    @PostMapping("/add")
    Client addClient(@RequestBody Client newClient)
    {
        return clientService.addClient(newClient);

    }
    @GetMapping("/get-all")
    public Iterable<Client> getClients()
    {
        return clientService.getClients();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable int id)
    {
        return clientService.deleteClient(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable int id)
    {
        return clientService.getClient(id);
    }
}
