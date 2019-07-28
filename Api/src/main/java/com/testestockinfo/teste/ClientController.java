package com.testestockinfo.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    private Map<Integer, Client> listaCliente = new HashMap<>();

    @RequestMapping(method = RequestMethod.POST)
    public Client create(@RequestBody Client request) {

        Client client = new Client(
                request.getName(),
                request.getCpf(),
                request.getGender(),
                request.getAge(),
                request.getBirthDate(),
                request.getEmail(),
                request.getPhoneNumber(),
                request.getAddress()
                );

        Account accountNormal = new Account('N');
        accountNormal.setClient(client);

        Account accountEventual = new Account('E');
        accountEventual.setClient(client);

        client.getAccountList().add(accountNormal);
        client.getAccountList().add(accountEventual);

        return clientRepository.save(client);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Map<Integer, Client> get() {

        return listaCliente;
    }

    @RequestMapping("/{id}")
    public Client getById(@PathVariable("id") int idClient){

        return listaCliente.get(idClient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Client edit(@PathVariable("id") int idClient,
                       @RequestBody Client request) {
        Client clientEdited = listaCliente.get(idClient);
        clientEdited.setPhoneNumber(request.getPhoneNumber());
        clientEdited.setEmail(request.getEmail());
        clientEdited.setAddress(request.getAddress());

        return clientEdited;
    }
}
