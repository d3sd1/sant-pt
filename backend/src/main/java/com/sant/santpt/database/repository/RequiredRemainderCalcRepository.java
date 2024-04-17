package com.sant.santpt.database.repository;

import com.sant.santpt.database.entity.RequiredRemainderCalc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface RequiredRemainderCalcRepository extends JpaRepository<RequiredRemainderCalc, Long> {
    Optional<RequiredRemainderCalc> findByXAndYAndN(BigInteger x, BigInteger y, BigInteger n);
}