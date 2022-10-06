package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDetailDTO;

import java.util.List;

public interface PeminjamanDetailService {
    PeminjamanDetailDTO save(PeminjamanDetailDTO param);

    List<PeminjamanDetailDTO> findAllData();

    PeminjamanDetailDTO update(PeminjamanDetailDTO param, Long id);

    Boolean delete(Long id);

    PeminjamanDetailDTO findById(Long id);
}
