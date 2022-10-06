package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import com.sinaukoding.perpustakaanfarhan.entity.Pengarang;
import com.sinaukoding.perpustakaanfarhan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PengarangDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PengarangMapping {
    PengarangMapping instance = Mappers.getMapper(PengarangMapping.class);

    Pengarang toEntity(PengarangDTO dto);

    PengarangDTO toDto(Pengarang param);

    List<PengarangDTO> toListDto   (List<Pengarang> pengarangList);
}
