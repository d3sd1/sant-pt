package com.sant.santpt.mapper.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequiredRemainderDto {
    private BigInteger x;
    private BigInteger y;
    private BigInteger n;
    private BigInteger result;
}
