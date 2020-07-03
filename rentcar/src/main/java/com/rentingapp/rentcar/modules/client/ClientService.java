package com.rentingapp.rentcar.modules.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Client addClient(Client client)
    {
        return clientRepository.save(client);
    }
    public Iterable<Client> getClients()
    {
        return clientRepository.findAll();
    }
    public ResponseEntity<?> getClient(int id)
    {
        try{
            Client client = clientRepository.findById(id).get();
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return new ResponseEntity<String>("Client with ID: " + id + " doesn't exist",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteClient(int id){
        try{
            clientRepository.deleteById(id);
            return new ResponseEntity<String>("Client with ID: " + id + " was deleted", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e)
        {
            return new ResponseEntity<String>("Client with ID: " + id + " doesn't exist", HttpStatus.OK);
        }
    }
}
