package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import com.sinaukoding.perpustakaanfarhan.entity.Peminjaman;
import com.sinaukoding.perpustakaanfarhan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanMapping {
    PeminjamanMapping instance = Mappers.getMapper(PeminjamanMapping.class);

    Peminjaman toEntity(PeminjamanDTO dto);

    PeminjamanDTO toDto(Peminjaman param);

    List<PeminjamanDTO> toListDto   (List<Peminjaman> peminjamanList);
}
