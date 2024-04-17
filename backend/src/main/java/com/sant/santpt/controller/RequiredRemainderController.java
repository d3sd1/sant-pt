package com.sant.santpt.controller;

import com.sant.santpt.database.exception.RequiredRemainderAlreadyCalculatedException;
import com.sant.santpt.mapper.RequiredRemainderMapper;
import com.sant.santpt.mapper.dto.RequiredRemainderDto;
import com.sant.santpt.service.RequiredRemainderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/required_remainder")
@RequiredArgsConstructor
@Slf4j
public class RequiredRemainderController {
    private final RequiredRemainderService requiredRemainderService;
    private final RequiredRemainderMapper requiredRemainderMapper;

    @GetMapping
    public RequiredRemainderDto getRequiredRemainder(@RequestParam(required = true) BigInteger x, @RequestParam(required = true) BigInteger y,
            @RequestParam(required = true) BigInteger n) {
        log.trace("Executing get required remainder.");
        return RequiredRemainderDto.builder().x(x).y(y).n(n).result(this.requiredRemainderService.calculate(x, y, n)).build();
    }

    @PostMapping
    public RequiredRemainderDto postRequiredRemainder(@RequestParam(required = true) BigInteger x, @RequestParam(required = true) BigInteger y,
            @RequestParam(required = true) BigInteger n) throws RequiredRemainderAlreadyCalculatedException {
        log.trace("Executing post required remainder.");
        return this.requiredRemainderMapper.requiredRemainderFromDbToDto(this.requiredRemainderService.store(x, y, n, this.requiredRemainderService.calculate(x, y, n)));
    }
}
