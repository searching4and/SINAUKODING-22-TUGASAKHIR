package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.PengarangDTO;

import java.util.List;

public interface PengarangService {
    PengarangDTO save(PengarangDTO param);

    List<PengarangDTO> findAllData();

    PengarangDTO update(PengarangDTO param, Long id);

    Boolean delete(Long id);

    PengarangDTO findById(Long id);
}
