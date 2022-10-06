package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDTO;

import java.util.List;

public interface PeminjamanService {
    PeminjamanDTO save(PeminjamanDTO param);

    List<PeminjamanDTO> findAllData();

    PeminjamanDTO update(PeminjamanDTO param, Long id);

    Boolean delete(Long id);

    PeminjamanDTO findById(Long id);
}
