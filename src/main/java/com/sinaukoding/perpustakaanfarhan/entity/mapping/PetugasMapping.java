package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import com.sinaukoding.perpustakaanfarhan.entity.Petugas;
import com.sinaukoding.perpustakaanfarhan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PetugasDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PetugasMapping {
    PetugasMapping instance = Mappers.getMapper(PetugasMapping.class);

    Petugas toEntity(PetugasDTO dto);

    PetugasDTO toDto(Petugas param);

    List<PetugasDTO> toListDto   (List<Petugas> petugasList);
}