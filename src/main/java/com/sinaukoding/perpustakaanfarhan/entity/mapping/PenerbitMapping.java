package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Penerbit;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PenerbitDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PenerbitMapping {
    PenerbitMapping instance = Mappers.getMapper(PenerbitMapping.class);

    Penerbit toEntity(PenerbitDTO dto);

    PenerbitDTO toDto(Penerbit param);

    List<PenerbitDTO> toListDto   (List<Penerbit> penerbitList);
}
