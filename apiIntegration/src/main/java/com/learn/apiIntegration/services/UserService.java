package com.learn.apiIntegration.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private RestTemplate restTemplate;

    public Map<String,Object> getUserData(){

        String url = "https://jsonplaceholder.typicode.com/users/1";

            Map<String,Object> response =restTemplate.getForObject(url,Map.class);
            Map<String,Object> address = (Map<String, Object>) response.get("address");
            Map<String,Object> company =(Map<String, Object>) response.get("company");

        Map<String, Object> filtered = new HashMap<>();
        filtered.put("Name", response.get("name"));
        filtered.put("Email_Id", response.get("email"));
        filtered.put("City", address.get("city"));
        filtered.put("Company",company.get("name"));
        return filtered;

    }

}
