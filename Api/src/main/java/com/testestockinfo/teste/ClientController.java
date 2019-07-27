package com.testestockinfo.teste;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @RequestMapping(method = RequestMethod.POST)
    public Client create() {



        return new Client();
    }
}
