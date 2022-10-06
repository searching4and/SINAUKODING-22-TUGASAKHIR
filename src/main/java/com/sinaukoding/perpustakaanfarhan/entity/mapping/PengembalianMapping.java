package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import com.sinaukoding.perpustakaanfarhan.entity.Pengembalian;
import com.sinaukoding.perpustakaanfarhan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PengembalianDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianMapping {
    PengembalianMapping instance = Mappers.getMapper(PengembalianMapping.class);

    Pengembalian toEntity(PengembalianDTO dto);

    PengembalianDTO toDto(Pengembalian param);

    List<PengembalianDTO> toListDto   (List<Pengembalian> pengembalianList);
}