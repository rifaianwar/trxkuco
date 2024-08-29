package com.r3s.trxservice.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TrxRq {
    @NotBlank(message = "email cannot be empty")
    @NotNull(message = "email cannot be null")
    private String email;
    @NotNull(message = "item cannot be null")
    private TrxItemRq item;
}
