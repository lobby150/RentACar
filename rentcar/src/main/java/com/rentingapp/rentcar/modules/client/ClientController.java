package com.rentingapp.rentcar.modules.client;

import com.rentingapp.rentcar.modules.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @PostMapping("/add")
    public Client addClient(@RequestBody Client newClient)
    {
        return clientService.addClient(newClient);

    }
    @GetMapping("/getAll")
    public Iterable<Client> getCars()
    {
        return clientService.getClients();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable int id)
    {
        return clientService.deleteClient(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCar(@PathVariable int id)
    {
        return clientService.getClient(id);
    }
}
