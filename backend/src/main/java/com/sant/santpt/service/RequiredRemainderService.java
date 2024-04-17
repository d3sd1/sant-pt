package com.sant.santpt.service;

import com.sant.santpt.database.entity.RequiredRemainderCalc;
import com.sant.santpt.database.exception.RequiredRemainderAlreadyCalculatedException;
import com.sant.santpt.database.repository.RequiredRemainderCalcRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class RequiredRemainderService {
    private final RequiredRemainderCalcRepository requiredRemainderCalcRepository;

    /**
     * Compeljidad algorítmica de O(log n). Realiza lo solicitado en: https://codeforces.com/problemset/problem/1374/A
     */
    public BigInteger calculate(BigInteger x, BigInteger y, BigInteger n) {
        final BigInteger z = n.mod(x);
        if (z.compareTo(y) > 0) {
            return n.subtract(z.subtract(y));
        } else if (z.compareTo(y) < 0) {
            return n.subtract(x).add(y.subtract(z));
        }
        return n;
    }

    public RequiredRemainderCalc store(BigInteger x, BigInteger y, BigInteger n, BigInteger result) throws RequiredRemainderAlreadyCalculatedException {
        if (this.requiredRemainderCalcRepository.findByXAndYAndN(x, y, n).isPresent()) {
            throw new RequiredRemainderAlreadyCalculatedException(String.format("Value was already calculated for x=%s y=%s and n=%s", x, y, n));
        }
        return this.requiredRemainderCalcRepository.save(RequiredRemainderCalc.builder().x(x).y(y).n(n).result(result).build());
    }

}
