package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.AnggotaDTO;

import java.util.List;

public interface AnggotaService {
    AnggotaDTO save(AnggotaDTO param);

    List<AnggotaDTO> findAllData();

    AnggotaDTO update(AnggotaDTO param, Long id);

    Boolean delete(Long id);

    AnggotaDTO findById(Long id);
}
