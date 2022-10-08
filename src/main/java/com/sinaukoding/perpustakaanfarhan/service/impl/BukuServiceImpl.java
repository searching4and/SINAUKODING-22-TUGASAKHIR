package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import com.sinaukoding.perpustakaanfarhan.entity.Penerbit;
import com.sinaukoding.perpustakaanfarhan.entity.Pengarang;
import com.sinaukoding.perpustakaanfarhan.entity.dto.BukuDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.BukuMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PenerbitMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PengarangMapping;
import com.sinaukoding.perpustakaanfarhan.repository.BukuRepository;
import com.sinaukoding.perpustakaanfarhan.repository.PenerbitRepository;
import com.sinaukoding.perpustakaanfarhan.repository.PengarangRepository;
import com.sinaukoding.perpustakaanfarhan.service.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BukuServiceImpl implements BukuService {

    @Autowired
    private BukuRepository repository;

    @Autowired
    private PengarangRepository pengarangRepository;

    @Autowired
    private PenerbitRepository penerbitRepository;

    @Transactional
    @Override
    public BukuDTO save(BukuDTO param) {
        Penerbit penerbit = PenerbitMapping.instance.toEntity(param.getPenerbit());
        Pengarang pengarang = PengarangMapping.instance.toEntity(param.getPengarang());
        Buku data = BukuMapping.instance.toEntity(param);

        if (param.getPenerbit() != null && param.getPengarang() != null) {
            penerbit = penerbitRepository.save(penerbit);
            pengarang = pengarangRepository.save(pengarang);

            data.getPengarang().setId(pengarang.getId());
            data.getPenerbit().setId(penerbit.getId());
        }

        data = repository.save(data);

        return BukuMapping.instance.toDto(data);
    }

    @Transactional
    @Override
    public List<BukuDTO> findAllData()
    {
        return BukuMapping.instance.toListDto(repository.findAll());

    }
    @Transactional
    @Override
    public BukuDTO update(BukuDTO param, Long id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            data.setJudul(param.getJudul()== null ? data.getJudul() : param.getJudul());
            data.setTahunTerbit(param.getTahunTerbit() != null ? param.getTahunTerbit() : data.getTahunTerbit());
            data.setJumlah(param.getJumlah() != null ? param.getJumlah() : data.getJumlah());
            data.setIsbn(param.getIsbn() != null ? param.getIsbn() : data.getIsbn());

            return  BukuMapping.instance.toDto(repository.save(data));
        }
        return BukuMapping.instance.toDto(data);

    }
    @Override
    public Boolean delete(Long id) {
        Buku data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public BukuDTO findById(Long id) {
        return BukuMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
