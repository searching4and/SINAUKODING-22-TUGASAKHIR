package com.sinaukoding.perpustakaanfarhan.service.impl;

import com.sinaukoding.perpustakaanfarhan.entity.Peminjaman;
import com.sinaukoding.perpustakaanfarhan.entity.Pengembalian;
import com.sinaukoding.perpustakaanfarhan.entity.dto.PengembalianDTO;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PeminjamanMapping;
import com.sinaukoding.perpustakaanfarhan.entity.mapping.PengembalianMapping;
import com.sinaukoding.perpustakaanfarhan.repository.AnggotaRepository;
import com.sinaukoding.perpustakaanfarhan.repository.PeminjamanRepository;
import com.sinaukoding.perpustakaanfarhan.repository.PengembalianRepository;
import com.sinaukoding.perpustakaanfarhan.repository.PetugasRepository;
import com.sinaukoding.perpustakaanfarhan.service.PengembalianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PengembalianServiceImpl implements PengembalianService {

    @Autowired
    private PengembalianRepository repository;

    @Autowired
    private PeminjamanRepository peminjamanRepository;

    @Autowired
    private AnggotaRepository anggotaRepository;

    @Autowired
    private PetugasRepository petugasRepository;


    @Transactional
    @Override
    public PengembalianDTO save(PengembalianDTO param) {
        Peminjaman peminjaman = PeminjamanMapping.instance.toEntity(param.getPeminjaman());

        Pengembalian data = PengembalianMapping.instance.toEntity(param);

        if (param.getPeminjaman() != null) {
            peminjaman = peminjamanRepository.save(peminjaman);

            data.getPeminjaman().setId(peminjaman.getId());
        }

        data = repository.save(data);

        return PengembalianMapping.instance.toDto(data);
    }

    @Transactional
    @Override
    public List<PengembalianDTO> findAllData()
    {
        return PengembalianMapping.instance.toListDto(repository.findAll());

    }
    @Transactional
    @Override
    public PengembalianDTO update(PengembalianDTO param, Long id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null){
            data.setTglPengembalian(param.getTglPengembalian()== null ? data.getTglPengembalian() : param.getTglPengembalian());
            data.setDenda(param.getDenda() != null ? param.getDenda() : data.getDenda());

            return  PengembalianMapping.instance.toDto(repository.save(data));
        }
        return PengembalianMapping.instance.toDto(data);

    }
    @Override
    public Boolean delete(Long id) {
        Pengembalian data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PengembalianDTO findById(Long id) {
        return PengembalianMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}