package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDetailDTO;

import java.util.List;

public interface PeminjamanDetailService {

    List<PeminjamanDetailDTO> findAllData();

    PeminjamanDetailDTO findById(Long id);
}
