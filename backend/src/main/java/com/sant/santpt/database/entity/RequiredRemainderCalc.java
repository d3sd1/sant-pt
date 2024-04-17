package com.sant.santpt.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class RequiredRemainderCalc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Min(value = 0L, message = "x value must be positive")
    private BigInteger x;
    @Min(value = 0L, message = "y value must be positive")
    private BigInteger y;
    @Min(value = 0L, message = "n value must be positive")
    private BigInteger n;
    private BigInteger result;
}
