package com.rentingapp.rentcar.modules.client;

import com.rentingapp.rentcar.modules.client.entity.Client;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {

    private static ClientService clientService;
    private static ClientRepository clientRepository;
    private final static List<Client> clients = new ArrayList<>();

    @BeforeAll
    public static void init()
    {
        clientRepository = Mockito.mock(ClientRepository.class);
        clientService = new ClientService(clientRepository);

        Client firstClient = new Client();
        firstClient.setClientId(1);
        firstClient.setFirstName("Marcin");
        firstClient.setSurname("Kubiak");
        firstClient.setRenting(false);

        Client secondClient = new Client();
        secondClient.setClientId(2);
        secondClient.setFirstName("Katarzyna");
        secondClient.setSurname("Nowak");
        secondClient.setRenting(false);

        clients.add(firstClient);
        clients.add(secondClient);

        Mockito.when(clientRepository.findAll()).thenReturn(clients);
        Mockito.when(clientRepository.getOne(1)).thenReturn(firstClient);
        Mockito.when(clientRepository.getOne(2)).thenReturn(secondClient);
        Mockito.when(clientRepository.save(firstClient)).thenReturn(firstClient);
        Mockito.when(clientRepository.save(secondClient)).thenReturn(secondClient);
    }
    @Test
    public void whenFindAllThenSizeCorrect()
    {
        int count = 0;
        Iterable<Client> clients = clientService.getClients();

        for (Client e : clients)
        {
            count ++;
        }
        assertNotNull(clients);
        assertEquals(2,count);
    }

    @Test
    public void whenFindById1ThenReturnFirstClient()
    {
        Client found = clientRepository.getOne(1);
        assertNotNull(found);
        assertEquals("Marcin",found.getFirstName());
    }

    @Test
    public void whenAddClientThenCorrect()
    {
        Client client = new Client();
        client.setFirstName("Ala");
        client.setSurname("Makota");
        clientService.addClient(client);

        Mockito.verify(clientRepository,Mockito.times(1)).save(client);
    }

    @Test
    public void whenAddClientWithFirstNameOnlyThenCorrect()
    {
        Client client = new Client();
        client.setFirstName("Tomasz");
        clientService.addClient(client);

        Mockito.verify(clientRepository,Mockito.times(1)).save(client);
    }
}