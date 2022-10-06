package com.sinaukoding.perpustakaanfarhan.entity.mapping;

import com.sinaukoding.perpustakaanfarhan.entity.Anggota;
import com.sinaukoding.perpustakaanfarhan.entity.PeminjamanDetail;
import com.sinaukoding.perpustakaanfarhan.entity.dto.AnggotaDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PeminjamanDetailMapping {
    PeminjamanDetailMapping instance = Mappers.getMapper(PeminjamanDetailMapping.class);

    PeminjamanDetail toEntity(PeminjamanDetailDTO dto);

    PeminjamanDetailDTO toDto(PeminjamanDetail param);

    List<PeminjamanDetailDTO> toListDto   (List<PeminjamanDetail> peminjamanDetailList);
}
