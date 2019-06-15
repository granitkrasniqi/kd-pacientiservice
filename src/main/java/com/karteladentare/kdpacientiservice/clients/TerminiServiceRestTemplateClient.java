package com.karteladentare.kdpacientiservice.clients;

import com.karteladentare.kdpacientiservice.domain.Termini;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TerminiServiceRestTemplateClient {

    @Autowired
    private RestTemplate restTemplate;

    private static final Logger logger = LoggerFactory.getLogger(TerminiServiceRestTemplateClient.class);

    public List<Termini> getTerminetByPatientId(Long pacientiId) {

        ResponseEntity<List<Termini>> restExchange =
                restTemplate.exchange(
                        "http://termini-service/v1/terminet/pacienti/{pacientiId}",
                        HttpMethod.GET,
                        null, new ParameterizedTypeReference<List<Termini>>(){}, pacientiId
                );

        logger.info("TermetExchangeBody = ", restExchange.getBody());
        return restExchange.getBody();
    }
}
