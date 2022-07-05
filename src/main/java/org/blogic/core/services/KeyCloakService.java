package org.blogic.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KeyCloakService {
    @Autowired
    private RestTemplate restTemplate;

    public void hello() {
    }
}
