package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.Pengarang;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PengarangDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PengarangMapping;
import com.sinaukoding.perpustakaanfarhan.repository.PengarangRepository;
import com.sinaukoding.perpustakaanfarhan.service.PengarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PengarangServiceImpl implements PengarangService {
    @Autowired
    private PengarangRepository repository;

    @Transactional
    @Override
    public PengarangDTO save(PengarangDTO param) {
        Pengarang data = repository.save(PengarangMapping.instance.toEntity(param));
        return PengarangMapping.instance.toDto(data);
    }

    @Transactional
    @Override
    public List<PengarangDTO> findAllData() {
        return PengarangMapping.instance.toListDto(repository.findAll());
    }

    @Transactional
    @Override
    public PengarangDTO update(PengarangDTO param, Long id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama(param.getNama() == null ? data.getNama() : param.getNama());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());
            data.setTelp(param.getTelp() != null ? param.getTelp() : data.getTelp());

            return PengarangMapping.instance.toDto(repository.save(data));
        }

        return PengarangMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Pengarang data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PengarangDTO findById(Long id) {
        return PengarangMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}

