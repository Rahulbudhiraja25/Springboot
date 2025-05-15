package com.learn.webApp.Controllers;


import com.learn.webApp.models.ClientDto;
import com.learn.webApp.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    public ClientRepository clientRepo;


    @GetMapping({"", "/"})
    public String getClients(Model model){
        var clients = clientRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("clients",clients);

        return "clients/index";
    }

    @GetMapping("/create")
    public String createClient(Model model){
        ClientDto clientDto = new ClientDto();
        model.addAttribute("clientDto",clientDto);
        return "/clients/create";
    }
}
