package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Anggota;
import com.sinaukoding.perpustakaanfarhan.entity.dto.AnggotaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface AnggotaMapping {
    AnggotaMapping instance = Mappers.getMapper(AnggotaMapping.class);

    Anggota toEntity(AnggotaDTO dto);

    AnggotaDTO toDto(Anggota param);

    List<AnggotaDTO> toListDto   (List<Anggota> anggotaList);
}
