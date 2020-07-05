package com.rentingapp.rentcar.modules.client;


import com.rentingapp.rentcar.modules.client.entity.Client;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    Client addClient(Client client)
    {
        return clientRepository.save(client);
    }
    Iterable<Client> getClients()
    {
        return clientRepository.findAll();
    }
    ResponseEntity<?> getClient(int id)
    {
        try{
            Client client = clientRepository.findById(id).orElseThrow();
            return new ResponseEntity<>(client, HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return new ResponseEntity<>("Client with ID: " + id + " doesn't exist",HttpStatus.NOT_FOUND);
        }
    }

    ResponseEntity<String> deleteClient(int id){

        try{
            Client client = clientRepository.findById(id).orElseThrow();
            if(client.isRenting())
            {
                return new ResponseEntity<>("This client is renting a car thus he cannot be deleted",HttpStatus.OK);
            }
            clientRepository.deleteById(id);
            return new ResponseEntity<>("Client with ID: " + id + " was deleted", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e)
        {
            return new ResponseEntity<>("Client with ID: " + id + " doesn't exist", HttpStatus.OK);
        }
    }
}
