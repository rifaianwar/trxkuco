package com.r3s.trxservice.model.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TrxItemRq {
    List<Long> itemId;
}
