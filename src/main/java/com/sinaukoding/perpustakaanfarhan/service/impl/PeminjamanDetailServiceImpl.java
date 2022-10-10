package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.Buku;
import com.sinaukoding.perpustakaanfarhan.entity.Peminjaman;
import com.sinaukoding.perpustakaanfarhan.entity.PeminjamanDetail;
import com.sinaukoding.perpustakaanfarhan.entity.Pengembalian;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PeminjamanDetailDTO;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PengembalianDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.BukuMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PeminjamanDetailMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PeminjamanMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PengembalianMapping;
import com.sinaukoding.perpustakaanfarhan.repository.*;
import com.sinaukoding.perpustakaanfarhan.service.PeminjamanDetailService;
import com.sinaukoding.perpustakaanfarhan.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PeminjamanDetailServiceImpl implements PeminjamanDetailService {

    @Autowired
    private PeminjamanDetailRepository repository;

    @Autowired
    private BukuRepository bukuRepository;

    @Transactional
    @Override
    public PeminjamanDetailDTO save(PeminjamanDetailDTO param) {
        Buku buku = BukuMapping.instance.toEntity(param.getBuku());

        PeminjamanDetail data = PeminjamanDetailMapping.instance.toEntity(param);

        if (param.getBuku() != null) {
            buku = bukuRepository.save(buku);

            data.getBuku().setId(buku.getId());
        }

        data = repository.save(data);

        return PeminjamanDetailMapping.instance.toDto(data);
    }

    @Transactional
    @Override
    public List<PeminjamanDetailDTO> findAllData()
    {
        return PeminjamanDetailMapping.instance.toListDto(repository.findAll());

    }


    @Override
    public PeminjamanDetailDTO findById(Long id) {
        return PeminjamanDetailMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}