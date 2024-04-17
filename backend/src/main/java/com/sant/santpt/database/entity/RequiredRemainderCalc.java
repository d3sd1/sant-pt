package com.sant.santpt.database.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "x is mandatory")
    private BigInteger x;
    @NotBlank(message = "y is mandatory")
    private BigInteger y;
    @NotBlank(message = "n is mandatory")
    private BigInteger n;
    @NotBlank(message = "result is mandatory")
    private BigInteger result;
}
