package com.example.backend.controller;

import com.example.backend.model.Client;
import com.example.backend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client clientData) {
        return clientRepository.findById(id).map(client -> {
            client.setName(clientData.getName());
            client.setLastName(clientData.getLastName());
            client.setPhone(clientData.getPhone());
            client.setEmail(clientData.getEmail());
            client.setAddress(clientData.getAddress());
            return clientRepository.save(client);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllClients() {
        clientRepository.deleteAll();
    }
}
