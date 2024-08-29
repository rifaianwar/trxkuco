package com.r3s.trxservice.service;



import com.r3s.trxservice.model.request.TrxRq;
import com.r3s.trxservice.model.response.TrxRs;

import java.util.UUID;

public interface TransactionService {
    TrxRs createTrx(TrxRq trxRq);
    TrxRs getTrx(UUID trxId);

}
