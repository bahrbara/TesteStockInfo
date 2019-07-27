package com.testestockinfo.teste;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    private Map<Integer, Client> listaCliente = new HashMap<>();

    @RequestMapping(method = RequestMethod.POST)
    public Map<Integer, Client> create(@RequestBody Client request) {

        Client cliente = new Client();

        cliente.setIdClient(request.getIdClient());
        cliente.setName(request.getName());
        cliente.setCpf(request.getCpf());
        cliente.setGender(request.getGender());
        cliente.setAge(request.getAge());
        cliente.setBirthDate(request.getBirthDate());
        cliente.setEmail(request.getEmail());
        cliente.setPhoneNumber(request.getPhoneNumber());
        cliente.setAddress(request.getAddress());

        System.out.println(cliente.toString());

        listaCliente.put(cliente.getIdClient(), cliente);

        return listaCliente;
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
