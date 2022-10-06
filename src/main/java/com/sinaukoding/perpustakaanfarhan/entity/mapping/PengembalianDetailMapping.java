package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import com.sinaukoding.perpustakaanfarhan.entity.PengembalianDetail;
import com.sinaukoding.perpustakaanfarhan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PengembalianDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengembalianDetailMapping {
    PengembalianDetailMapping instance = Mappers.getMapper(PengembalianDetailMapping.class);

    PengembalianDetail toEntity(PengembalianDetailDTO dto);

    PengembalianDetailDTO toDto(PengembalianDetail param);

    List<PengembalianDetailDTO> toListDto   (List<PengembalianDetail> pengembalianDetailList);
}
