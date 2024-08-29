package com.r3s.trxservice.service.impl;


import com.google.gson.Gson;
import com.r3s.trxservice.model.request.TrxRq;
import com.r3s.trxservice.model.response.GenericResponse;
import com.r3s.trxservice.model.response.TrxRs;
import com.r3s.trxservice.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Override
    public TrxRs createTrx(TrxRq trxRq) {
        String uri = "http://localhost:9090/trx/create";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<TrxRq> req = new HttpEntity<>(trxRq);
        ResponseEntity<GenericResponse<TrxRs>> res = restTemplate.exchange(uri, HttpMethod.POST, req, new ParameterizedTypeReference<GenericResponse<TrxRs>>() {});
        Gson gson = new Gson();
        log.info("RESPONSENYA [{}] ",gson.toJson(res.getBody().getData()));
        TrxRs trxRs = res.getBody().getData();
        return trxRs;
    }

    @Override
    public TrxRs getTrx(UUID trxId) {
        String uri = "http://localhost:9090/trx/get";
        String builder = UriComponentsBuilder.fromHttpUrl(uri)
                .queryParam("trxId",trxId)
                .toUriString();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<GenericResponse<TrxRs>> res = restTemplate.exchange(builder, HttpMethod.GET, null, new ParameterizedTypeReference<GenericResponse<TrxRs>>() {});
        TrxRs trxRs = res.getBody().getData();
        Gson gson = new Gson();
        log.info("RESPONSENYA [{}] ",gson.toJson(res.getBody().getData()));
        return trxRs;
    }
}
