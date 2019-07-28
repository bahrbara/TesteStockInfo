package com.testestockinfo.teste.Controller;

import com.testestockinfo.teste.Model.Account;
import com.testestockinfo.teste.Model.Client;
import com.testestockinfo.teste.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Client create(@RequestBody Client request) {

        Client client = new Client(
                request.getName(),
                request.getCpf(),
                request.getGender(),
                request.getBirthDate(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getAddress()
                );

        Account accountNormal = new Account('N');
        Account accountEventual = new Account('E');

        client.getAccountList().add(accountNormal);
        client.getAccountList().add(accountEventual);

        return clientRepository.save(client);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Client> get() {
        return clientRepository.findAll();
    }

    @RequestMapping("/{id}")
    public Optional<Client> getById(@PathVariable("id") int idClient){
        return clientRepository.findById(idClient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Client edit(@PathVariable("id") int idClient, @RequestBody Client request) throws Exception {
        Client clientEdited = clientRepository.findById(idClient).orElseThrow(() -> new Exception("Cliente não encontrado"));
        clientEdited.setPhoneNumber(request.getPhoneNumber());
        clientEdited.setEmail(request.getEmail());
        clientEdited.setAddress(request.getAddress());

        clientRepository.save(clientEdited);

        return clientEdited;
    }
}