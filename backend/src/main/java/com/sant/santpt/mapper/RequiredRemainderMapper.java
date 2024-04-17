package com.sant.santpt.mapper;

import com.sant.santpt.database.entity.RequiredRemainderCalc;
import com.sant.santpt.mapper.dto.RequiredRemainderDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequiredRemainderMapper {

    RequiredRemainderDto requiredRemainderFromDbToDto(RequiredRemainderCalc entity);

    RequiredRemainderCalc requiredRemainderFromDtoToDb(RequiredRemainderDto dto);
}
