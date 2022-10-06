package com.sinaukoding.perpustakaanfarhan.service;

import com.sinaukoding.perpustakaanfarhan.entity.dto.PenerbitDTO;

import java.util.List;

public interface PenerbitService {
    PenerbitDTO save(PenerbitDTO param);

    List<PenerbitDTO> findAllData();

    PenerbitDTO update(PenerbitDTO param, Long id);

    Boolean delete(Long id);

    PenerbitDTO findById(Long id);
}
